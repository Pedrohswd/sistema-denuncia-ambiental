package com.felas.ambieep.controller;

import com.felas.ambieep.entites.Denunciation;
import com.felas.ambieep.entites.records.denunciation.*;
import com.felas.ambieep.services.DenunciationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/denunciation")
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

    @PutMapping("/progress")
    public ResponseEntity<String> progressComplaint(@RequestBody DenunciationPUTProgJOSN denunciationPUTProgJOSN){
        return ResponseEntity.ok(denunciationService.progressComplaint(denunciationPUTProgJOSN));
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateCategory(@RequestBody DenunciationPUTUpJSON denunciationPUTUpJSON){
        return ResponseEntity.ok(denunciationService.updateCategoryDenun(denunciationPUTUpJSON));
    }

    @PutMapping("/conclude")
    public  ResponseEntity<String> progressConclude(@RequestBody DenunciationPUTConcludeJSON denunciationPUTConcludeJSON){
        return ResponseEntity.ok(denunciationService.progressConclude(denunciationPUTConcludeJSON));
    }

    @GetMapping("/find")
    public ResponseEntity<List<Denunciation>> findByParameters(@RequestBody DenunciationGETPJSON denunciationGETPJSON){
        return ResponseEntity.ok(denunciationService.findByParameters(denunciationGETPJSON));
    }

}
