package com.felas.ambieep.services;

import com.felas.ambieep.entites.Denunciation;
import com.felas.ambieep.entites.Photos;
import com.felas.ambieep.entites.TechnicalRegister;
import com.felas.ambieep.entites.User;
import com.felas.ambieep.entites.enums.State;
import com.felas.ambieep.entites.records.denunciation.*;
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
        if (denunciation.getUser().getCpf() == null) {
            User user = userRepository.findByCpf("null");
            denunciation.setUser(user);
        } else {
            User usr = userRepository.findByCpf(denunciationJSON.user().getCpf());
            denunciation.setUser(usr);
        }
        denunciation = denunciationRepository.save(denunciation);
        denunciation.setnProtocol(denunciation.getId() + "/" + Dates.year());
        denunciation.setDateCreated(Dates.formaterToDaS(denunciation.getDateCreated()));
        denunciation.setDateFact(denunciation.getDateFact());
        denunciationRepository.save(denunciation);
        return denunciation.getnProtocol();
    }

    public Denunciation findByProtocol(String string) {
        Denunciation denunciation = denunciationRepository.findByNProtocol(string);
        if (denunciation != null) {
            List<Photos> photos = photosRepository.findByDenunciationId(denunciation.getId());
            denunciation.setPhotos(photos);
            denunciation.getUser().setPassword("");
            if (denunciation.getTechnicalRegister() != null && denunciation.getTechnicalRegister().getAnalystUser() != null) {
                denunciation.getTechnicalRegister().getAnalystUser().setPassword("");
            }
        }

        return denunciation;
    }

    public String progressComplaint(DenunciationPUTProgJOSN denunciationPUTProgJOSN) {
        Denunciation denunciation = findByProtocol(denunciationPUTProgJOSN.nProtocol());
        denunciation.setSituation(denunciationPUTProgJOSN.situation());
        TechnicalRegister technicalRegister = new TechnicalRegister(null, userRepository.findByCpf(denunciationPUTProgJOSN.analystCPF()), denunciationPUTProgJOSN.description(), null);
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

    public List<Denunciation> findByParameters(DenunciationGETPJSON denunciationGETPJSON) {
        List<Denunciation> list = null;
        if (denunciationGETPJSON.state() != null) {
            String idState = State.getIdFromState(denunciationGETPJSON.state()) + "";
            list = denunciationRepository.findyByParameters(denunciationGETPJSON.categoryType(),
                    denunciationGETPJSON.conty(), idState, denunciationGETPJSON.category(),
                    denunciationGETPJSON.cpf(), denunciationGETPJSON.dateReg(), denunciationGETPJSON.dateFact(), denunciationGETPJSON.situation());
        } else {
            list = denunciationRepository.findyByParameters(denunciationGETPJSON.categoryType(),
                    denunciationGETPJSON.conty(), null, denunciationGETPJSON.category(),
                    denunciationGETPJSON.cpf(), denunciationGETPJSON.dateReg(), denunciationGETPJSON.dateFact(), denunciationGETPJSON.situation());
        }

        return list;
    }

    public String updateCategoryDenun(DenunciationPUTUpJSON denunciationPUTUpJSON) {
        Denunciation denunciation = findByProtocol(denunciationPUTUpJSON.nProtocol());
        denunciation.setCategory(denunciationPUTUpJSON.category());
        denunciationRepository.save(denunciation);
        return "Update Conclude";
    }
}
