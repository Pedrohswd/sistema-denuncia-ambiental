package com.felas.ambieep.entites;

import com.felas.ambieep.enumeration.Permission;
import jakarta.persistence.*;


@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private String password;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Permission permission;

    public User(){

    }

    public User(Long id, String cpf, String password, String nome, Permission permission) {
        this.id = id;
        this.cpf = cpf;
        this.password = password;
        this.nome = nome;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
