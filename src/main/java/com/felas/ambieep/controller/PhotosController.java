package com.felas.ambieep.controller;

import com.felas.ambieep.entites.records.PhotosJSON;
import com.felas.ambieep.services.PhotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/photos")
public class PhotosController {
    @Autowired
    private PhotosService photosService;


    @PostMapping("/insert")
    public ResponseEntity<String> insertImg(@RequestBody PhotosJSON photosJSON){
        return ResponseEntity.ok(photosService.insertImg(photosJSON));
    }
}
