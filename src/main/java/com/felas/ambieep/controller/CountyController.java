package com.felas.ambieep.controller;

import com.felas.ambieep.entites.County;
import com.felas.ambieep.entites.enums.State;
import com.felas.ambieep.entites.records.CountyJSON;
import com.felas.ambieep.entites.records.StateJSON;
import com.felas.ambieep.services.CountyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/county")
public class CountyController {
    @Autowired
    private CountyService countyService;

    @GetMapping("/list/{state}")
    public ResponseEntity<List<County>> countiesByState(@PathVariable State state){
        return ResponseEntity.ok(countyService.listarMunicipiosDaUF(state));
    }
}
