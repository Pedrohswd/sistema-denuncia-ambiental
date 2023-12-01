package com.felas.ambieep.services;

import com.felas.ambieep.entites.Denunciation;
import com.felas.ambieep.entites.Photos;
import com.felas.ambieep.entites.records.PhotosJSON;
import com.felas.ambieep.repositories.DenunciationRepository;
import com.felas.ambieep.repositories.PhotosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotosService {
    @Autowired
    private PhotosRepository photosRepository;

    @Autowired
    private DenunciationRepository denunciationRepository;

    public String insertImg(PhotosJSON photosJSON) {
        Denunciation denunciation = denunciationRepository.findByNProtocol(photosJSON.nProtocol());
        Photos photos = new Photos(photosJSON.imgBase64(), denunciation);
        photosRepository.save(photos);
        return "Created img";
    }
}
