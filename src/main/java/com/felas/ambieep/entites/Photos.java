package com.felas.ambieep.entites;

import jakarta.persistence.*;

@Entity
@Table(name = "photos")
public class Photos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Lob
    private byte[] photo;
    @ManyToOne
    @JoinColumn(name = "denunciation_id")
    private Denunciation denunciation;

    public Photos(){

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
