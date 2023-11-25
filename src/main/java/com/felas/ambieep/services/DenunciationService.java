package com.felas.ambieep.services;

import com.felas.ambieep.entites.Denunciation;
import com.felas.ambieep.entites.Photos;
import com.felas.ambieep.entites.records.DenunciationJSON;
import com.felas.ambieep.entites.records.PhotosJSON;
import com.felas.ambieep.repositories.AddressRepository;
import com.felas.ambieep.repositories.DenunciationRepository;
import com.felas.ambieep.repositories.PhotosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DenunciationService {

    @Autowired
    private DenunciationRepository denunciationRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PhotosRepository photosRepository;

    public String createDenun(DenunciationJSON denunciationJSON) {
        Denunciation denunciation = new Denunciation(denunciationJSON);
        denunciationRepository.save(denunciation);
        return "Created";
    }

    public Optional<Denunciation> findById(Long id) {
        return denunciationRepository.findById(id);
    }
}
