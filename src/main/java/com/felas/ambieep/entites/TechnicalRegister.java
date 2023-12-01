package com.felas.ambieep.entites;

import com.felas.ambieep.entites.records.TechnicalRegisterJSON;
import com.felas.ambieep.utils.Dates;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class TechnicalRegister {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private User analystUser;
    private String technicalReport;
    @Column(name = "description_tr")
    private String description;
    private Date updateDate;

    public TechnicalRegister() {

    }

    public TechnicalRegister(Long id, User analystUser, String description,String technicalReport) {
        this.id = id;
        this.analystUser = analystUser;
        this.description = description;
        this.technicalReport = technicalReport;
        this.updateDate = Dates.now();
    }

    public TechnicalRegister(TechnicalRegisterJSON technicalRegisterJSON) {
        this.analystUser = technicalRegisterJSON.analystUser();
        this.technicalReport = technicalRegisterJSON.technicalReport();
        this.updateDate = Dates.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getAnalystUser() {
        return analystUser;
    }

    public void setAnalystUser(User analystUser) {
        this.analystUser = analystUser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTechnicalReport() {
        return technicalReport;
    }

    public void setTechnicalReport(String technicalReport) {
        this.technicalReport = technicalReport;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
