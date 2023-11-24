package com.felas.ambieep.services;

import com.felas.ambieep.entites.Address;
import com.felas.ambieep.entites.Denunciation;
import com.felas.ambieep.entites.records.DenunciationJSON;
import com.felas.ambieep.repositories.AddressRepository;
import com.felas.ambieep.repositories.DenunciationRepository;
import com.felas.ambieep.repositories.PhotosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DenunciationService {

    @Autowired
    private DenunciationRepository denunciationRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PhotosRepository photosRepository;

    public void createDenun(DenunciationJSON denunciationJSON) {
        Address address = new Address(denunciationJSON.address());
        addressRepository.save(address);
        Denunciation denunciation = new Denunciation(denunciationJSON);
        denunciationRepository.save(denunciation);
    }
}
