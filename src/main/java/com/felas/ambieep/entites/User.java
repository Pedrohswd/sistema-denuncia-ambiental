package com.felas.ambieep.entites;

import com.felas.ambieep.entites.enums.Permission;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true, nullable = false)
    private String cpf;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @Column(unique=true,nullable = false)
    private String phone;
    @Enumerated(EnumType.STRING)
    private Permission permission;

    @OneToMany(mappedBy = "user")
    private List<Denunciation> denunciation;

    public User(){

    }

    public User(Long id, String cpf, String password, String name, String phone,Permission permission) {
        this.id = id;
        this.cpf = cpf;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.permission = permission;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String senha) {
        this.password = senha;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;

    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
