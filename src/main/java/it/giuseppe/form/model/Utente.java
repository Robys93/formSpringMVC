package it.giuseppe.form.model;

import lombok.AllArgsConstructor;


import java.time.LocalDate;
import java.util.Date;

public class Utente {
    private String nome;
    private String email;
    private String password;
    private String confermaPassword;
    private Date dataDiNascita;
    private String numeroTelefono;

    public Utente(String nome, String email, String password, String confermaPassword, Date dataDiNascita, String numeroTelefono) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.confermaPassword = confermaPassword;
        this.dataDiNascita = dataDiNascita;
        this.numeroTelefono = numeroTelefono;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfermaPassword() {
        return confermaPassword;
    }

    public Date getDataDiNascita() {
        return dataDiNascita;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfermaPassword(String confermaPassword) {
        this.confermaPassword = confermaPassword;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
}


