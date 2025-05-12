package it.giuseppe.form.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utente {
    private String nome;
    private String email;
    private String password;
    private String confermaPassword;
    private String dataDiNascita;
    private String numeroTelefono;
}