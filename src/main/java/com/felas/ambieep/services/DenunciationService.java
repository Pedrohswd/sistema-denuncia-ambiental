package com.felas.ambieep.services;

import com.felas.ambieep.entites.Denunciation;
import com.felas.ambieep.entites.Photos;
import com.felas.ambieep.entites.records.denunciation.DenunciationPOSTJSON;
import com.felas.ambieep.repositories.AddressRepository;
import com.felas.ambieep.repositories.DenunciationRepository;
import com.felas.ambieep.repositories.PhotosRepository;
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
    private PhotosRepository photosRepository;



    public String createDenun(DenunciationPOSTJSON denunciationJSON) {
        Denunciation denunciation = new Denunciation(denunciationJSON);
        denunciationRepository.save(denunciation);
        return "Created";
    }

    public Denunciation findByProtocol(String string){
        Denunciation denunciation = denunciationRepository.findByNProtocol(string);
        List<Photos> photos = photosRepository.findByDenunciationId(denunciation.getId());
        denunciation.setPhotos(photos);
        return denunciation;
    }
}
