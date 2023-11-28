package com.felas.ambieep.controller;

import com.felas.ambieep.entites.Denunciation;
import com.felas.ambieep.entites.records.denunciation.DenunciationGETJSON;
import com.felas.ambieep.entites.records.denunciation.DenunciationPOSTJSON;
import com.felas.ambieep.services.DenunciationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/denunciation", produces = MediaType.APPLICATION_JSON_VALUE)
public class DenunciationController {

    @Autowired
    private DenunciationService denunciationService;


    @PostMapping("/create")
    public ResponseEntity<String> createDenun(@RequestBody DenunciationPOSTJSON denunciationJSON){
        return ResponseEntity.ok(denunciationService.createDenun(denunciationJSON));
    }
    @GetMapping(value = "/protocol")
    public ResponseEntity<Denunciation> findDenunciationDTO(@RequestBody DenunciationGETJSON nProtocol){
        return ResponseEntity.ok(denunciationService.findByProtocol(nProtocol.nProtocol()));
    }

}
