package com.felas.ambieep.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.felas.ambieep.entites.records.PhotosJSON;
import com.felas.ambieep.utils.Image;
import jakarta.persistence.*;

import java.util.Base64;

@Entity
@Table(name = "photos")
public class Photos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private byte[] photo;

    @ManyToOne
    @JoinColumn(name = "denunciation_id")
    @JsonIgnore
    private Denunciation denunciation;

    public Photos() {

    }

    public Photos(String imgBase64, Denunciation denunciation) {
        imgBase64 = imgBase64.replaceAll("\\s", "");
        imgBase64 = imgBase64.replaceAll("[^A-Za-z0-9+/=]", "");
        this.photo = Image.convertBase64ToByte(imgBase64);
        this.denunciation = denunciation;

    }

    public Photos(long id, byte[] photo, Denunciation denunciation) {
        this.id = id;
        this.photo = photo;
        this.denunciation = denunciation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Denunciation getDenunciation() {
        return denunciation;
    }

    public void setDenunciation(Denunciation denunciation) {
        this.denunciation = denunciation;
    }

}
