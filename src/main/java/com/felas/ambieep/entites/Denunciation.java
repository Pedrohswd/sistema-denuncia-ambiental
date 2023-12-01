package com.felas.ambieep.entites;

import com.felas.ambieep.entites.enums.Situation;
import com.felas.ambieep.entites.records.denunciation.DenunciationPOSTJSON;
import com.felas.ambieep.utils.Dates;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "denunciation")
public class Denunciation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_denun")
    private Long id;
    @Column(unique = true)
    private String nProtocol;
    @OneToMany(mappedBy = "denunciation", cascade = CascadeType.ALL)
    private List<Photos> photos = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id", referencedColumnName = "id_adr")
    private Address address;
    @Column(name = "descrpition_user")
    private String description;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id_categ")
    private Category category;
    @Column(nullable = false)
    private Date dateFact;
    private Date dateCreated;
    @Column(nullable = false)
    private String author;
    @Enumerated(EnumType.STRING)
    private Situation situation;
    @OneToOne
    @JoinColumn(name = "techinical_id", referencedColumnName = "id")
    private TechnicalRegister technicalRegister;

    public Denunciation() {
    }

    public Denunciation(DenunciationPOSTJSON denunciationJSON) {
        this.nProtocol = denunciationJSON.nProtocol();
        this.user = denunciationJSON.user();
        this.description = denunciationJSON.description();
        this.category = denunciationJSON.category();
        this.dateFact = denunciationJSON.dateFact();
        this.dateCreated = Dates.now();
        this.author = denunciationJSON.author();
        this.address = denunciationJSON.address();
        this.situation = denunciationJSON.situation();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getnProtocol() {
        return nProtocol;
    }

    public void setnProtocol(String nProtocol) {
        this.nProtocol = nProtocol;
    }

    public List<Photos> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photos> photos) {
        this.photos = photos;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getDateFact() {
        return dateFact;
    }

    public void setDateFact(Date dateFact) {
        this.dateFact = dateFact;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Situation getSituation() {
        return situation;
    }

    public void setSituation(Situation situation) {
        this.situation = situation;
    }

    public TechnicalRegister getTechnicalRegister() {
        return technicalRegister;
    }

    public void setTechnicalRegister(TechnicalRegister technicalRegister) {
        this.technicalRegister = technicalRegister;
    }
}
