package com.felas.ambieep.entites;

import com.felas.ambieep.entites.enums.Situation;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "denunciation")
public class Denunciation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "denunciation", cascade = CascadeType.ALL)
    private List<Photos> photos;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    private String description;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
    private Date dateFact;
    private Date dateCreated;
    private String author;
    private Situation situation;

}
