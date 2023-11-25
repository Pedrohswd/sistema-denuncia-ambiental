package com.felas.ambieep.controller;

import com.felas.ambieep.entites.Denunciation;
import com.felas.ambieep.entites.records.DenunciationJSON;
import com.felas.ambieep.entites.records.PhotosJSON;
import com.felas.ambieep.services.DenunciationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/denunciation")
public class DenunciationController {

    @Autowired
    private DenunciationService denunciationService;

    @PostMapping("/create")
    public ResponseEntity<String> createDenun(@RequestBody DenunciationJSON denunciationJSON){
        return ResponseEntity.ok(denunciationService.createDenun(denunciationJSON));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Denunciation>> findCategory(@PathVariable Long id){
        return ResponseEntity.ok(denunciationService.findById(id));
    }
}
