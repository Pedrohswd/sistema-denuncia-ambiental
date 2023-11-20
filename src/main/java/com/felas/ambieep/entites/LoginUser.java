package com.felas.ambieep.entites;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "user_login")
public class LoginUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String cpf;
    @Column(name = "date_login", nullable = false)
    private Date dateLogin;

    public LoginUser() {

    }

    public LoginUser(Long id, String cpf, Date dateLogin) {
        this.id = id;
        this.cpf = cpf;
        this.dateLogin = dateLogin;
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

    public Date getDateLogin() {
        return dateLogin;
    }

    public void setDateLogin(Date dateLogin) {
        this.dateLogin = dateLogin;
    }
}
