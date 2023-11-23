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
}
