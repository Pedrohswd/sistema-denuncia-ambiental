package com.felas.ambieep.entites;

import com.felas.ambieep.entites.enums.State;
import com.felas.ambieep.entites.records.CountyJSON;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "contries")
public class County {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String contry;
    @Column(name = "id_IBGE", nullable = false)
    private Long idIBGE;
    @Enumerated(EnumType.STRING)
    private State state;
    @OneToMany(mappedBy = "county")
    private List<Address> address;

    public County() {

    }

    public County(CountyJSON countyJSON) {
        this.idIBGE = countyJSON.id();
        this.contry = countyJSON.nome();
        this.state = countyJSON.regiaoImediata().regiaoIntermediaria().UF().siglaUF();
    }

    public County(Long id, Long idIBGE, String contry, State state) {
        this.id = id;
        this.idIBGE = idIBGE;
        this.contry = contry;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdIBGE() {
        return idIBGE;
    }

    public void setIdIBGE(Long idIBGE) {
        this.idIBGE = idIBGE;
    }

    public String getContry() {
        return contry;
    }

    public void setContry(String contry) {
        this.contry = contry;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
