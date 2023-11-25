package com.felas.ambieep.services;

import com.felas.ambieep.entites.Denunciation;
import com.felas.ambieep.entites.Photos;
import com.felas.ambieep.entites.records.PhotosJSON;
import com.felas.ambieep.repositories.DenunciationRepository;
import com.felas.ambieep.repositories.PhotosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotosService {
    @Autowired
    private PhotosRepository photosRepository;

    @Autowired
    private DenunciationRepository denunciationRepository;

    public String insertImg(PhotosJSON photosJSON){
        Denunciation denunciation = denunciationRepository.findByNProtocol(photosJSON.nProtocol());
        for(String photo: photosJSON.imgBase64()){
            Photos photos = new Photos(photo, denunciation);
        }
        return "Created img";
    }

}
