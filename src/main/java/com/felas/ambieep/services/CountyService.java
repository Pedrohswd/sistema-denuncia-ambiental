package com.felas.ambieep.services;

import com.felas.ambieep.api.CountyAPI;
import com.felas.ambieep.entites.County;
import com.felas.ambieep.entites.enums.State;
import com.felas.ambieep.entites.records.CountyJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountyService {
    @Autowired
    private CountyAPI countyAPI;

    public List<County> listarMunicipiosDaUF(State acronym){
        List<County> lista = new ArrayList<>();
        for (CountyJSON m : countyAPI.contryByState(acronym)){
            lista.add(new County(m));
        }
        return lista;
    }
}
