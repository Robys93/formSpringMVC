package it.giuseppe.form.controller;

import it.giuseppe.form.model.Utente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UtenteController {

    @GetMapping("/form")
    public String getForm() {
        return "form";
    }

    @GetMapping("/form2")
    public String getForm2(@ModelAttribute Utente utente) {
        return "form2";
    }

    @PostMapping("/submitForm")
    public String postForm(@ModelAttribute Utente utente, Model model) {
        // 1. Controllo nomi bannati
        if (isNomeBannato(utente.getNome())) {
            return errore(model, "Nome utente non permesso", utente.getNome());
        }

        // 2. Controllo lunghezza nome
        if (utente.getNome().length() < 3 || utente.getNome().length() > 20) {
            return errore(model, "Il nome deve essere tra 3 e 20 caratteri", utente.getNome());
        }

        // 3. Validazione email
        if (!isEmailValida(utente.getEmail())) {
            return errore(model, "Formato email non valido", utente.getEmail());
        }

        // 4. Validazione telefono
        if (!isTelefonoValido(utente.getNumeroTelefono())) {
            return errore(model, "Numero di telefono non valido", utente.getNumeroTelefono());
        }

        // 5. Controllo password
        if (!utente.getPassword().equals(utente.getConfermaPassword())) {
            return errore(model, "Le password non coincidono", "");
        }

        // 6. Validazione data
        if (utente.getDataDiNascita() == null || utente.getDataDiNascita().isEmpty()) {
            return errore(model, "Data di nascita non valida", "");
        }

        model.addAttribute("utente", utente);
        return "result";
    }

    private boolean isNomeBannato(String nome) {
        List<String> nomiBannatiList = List.of("admin", "root");
        return nomiBannatiList.contains(nome.toLowerCase());
    }

    private boolean isEmailValida(String email) {
        if (email == null || email.isEmpty()) return false;

        int atIndex = email.indexOf('@');
        if (atIndex <= 0 || atIndex != email.lastIndexOf('@')) return false;

        int dotIndex = email.indexOf('.', atIndex);
        return !(dotIndex <= atIndex + 1 || dotIndex == email.length() - 1);
    }

    private boolean isTelefonoValido(String telefono) {
        if (telefono == null || telefono.isEmpty()) return false;

        int digitCount = 0;
        char primoCarattere = telefono.charAt(0);

        if (primoCarattere != '+' && !Character.isDigit(primoCarattere)) {
            return false;
        }

        for (char c : telefono.toCharArray()) {
            if (Character.isDigit(c)) {
                digitCount++;
            } else if (c != '+' && c != ' ' && c != '-' && c != '(' && c != ')') {
                return false;
            }
        }

        return digitCount >= 9 && digitCount <= 15;
    }

    private String errore(Model model, String messaggio, String input) {
        model.addAttribute("error", messaggio);
        model.addAttribute("input", input);
        return "error";
    }
}