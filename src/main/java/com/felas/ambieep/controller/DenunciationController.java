package com.felas.ambieep.controller;

import com.felas.ambieep.entites.records.DenunciationJSON;
import com.felas.ambieep.services.DenunciationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/denunciation")
public class DenunciationController {

    @Autowired
    private DenunciationService denunciationService;

    @PostMapping("/create")
    public void createDenun(@RequestBody DenunciationJSON denunciationJSON){
        denunciationService.createDenun(denunciationJSON);
    }
}
