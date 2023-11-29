package com.felas.ambieep.services;

import com.felas.ambieep.entites.Denunciation;
import com.felas.ambieep.entites.Photos;
import com.felas.ambieep.entites.TechnicalRegister;
import com.felas.ambieep.entites.records.TechnicalRegisterJSON;
import com.felas.ambieep.entites.records.denunciation.DenunciationPOSTJSON;
import com.felas.ambieep.entites.records.denunciation.DenunciationPUTConcludeJSON;
import com.felas.ambieep.entites.records.denunciation.DenunciationPUTProgJOSN;
import com.felas.ambieep.repositories.*;
import com.felas.ambieep.utils.Dates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DenunciationService {

    @Autowired
    private DenunciationRepository denunciationRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PhotosRepository photosRepository;

    @Autowired
    private TechinicalRegisterRepository techinicalRegisterRepository;


    public String createDenun(DenunciationPOSTJSON denunciationJSON) {
        Denunciation denunciation = new Denunciation(denunciationJSON);
        denunciation = denunciationRepository.save(denunciation);
        denunciation.setnProtocol(denunciation.getId() + "/" + Dates.year());
        denunciationRepository.save(denunciation);
        return "Created protocol " + denunciation.getnProtocol();
    }

    public Denunciation findByProtocol(String string) {
        Denunciation denunciation = denunciationRepository.findByNProtocol(string);
        List<Photos> photos = photosRepository.findByDenunciationId(denunciation.getId());
        denunciation.setPhotos(photos);
        denunciation.getUser().setPassword("");
        if (denunciation.getTechnicalRegister() != null && denunciation.getTechnicalRegister().getAnalystUser() != null){
            denunciation.getTechnicalRegister().getAnalystUser().setPassword("");
        }
        return denunciation;
    }

    public String progressComplaint(DenunciationPUTProgJOSN denunciationPUTProgJOSN) {
        Denunciation denunciation = findByProtocol(denunciationPUTProgJOSN.nProtocol());
        denunciation.setSituation(denunciationPUTProgJOSN.situation());
        TechnicalRegister technicalRegister = new TechnicalRegister(null, userRepository.findByCpf(denunciationPUTProgJOSN.analystCPF()), null);
        technicalRegister = techinicalRegisterRepository.save(technicalRegister);
        denunciation.setTechnicalRegister(technicalRegister);
        denunciationRepository.save(denunciation);
        return "Protocol " + denunciationPUTProgJOSN.nProtocol() + " in progress";
    }

    public String progressConclude(DenunciationPUTConcludeJSON denunciationPUTConcludeJSON) {
        Denunciation denunciation = findByProtocol(denunciationPUTConcludeJSON.nProtocol());
        denunciation.setSituation(denunciationPUTConcludeJSON.situation());
        TechnicalRegister technicalRegister = denunciation.getTechnicalRegister();
        technicalRegister.setTechnicalReport(denunciationPUTConcludeJSON.technicalReport());
        techinicalRegisterRepository.save(technicalRegister);
        denunciationRepository.save(denunciation);

        return "Protocol " + denunciationPUTConcludeJSON.nProtocol() + " concluded";
    }
}
