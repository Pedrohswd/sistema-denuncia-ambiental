package com.felas.ambieep.entites;

import com.felas.ambieep.entites.enums.State;
import com.felas.ambieep.entites.records.CountyJSON;
import jakarta.persistence.*;

import java.util.List;

public class County {
    private String contry;

    public County() {

    }

    public County(CountyJSON countyJSON) {
        this.contry = countyJSON.nome();
    }

    public County(String contry) {
        this.contry = contry;
    }

    public String getContry() {
        return contry;
    }

    public void setContry(String contry) {
        this.contry = contry;
    }

}
