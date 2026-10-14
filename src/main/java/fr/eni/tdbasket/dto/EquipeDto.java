package fr.eni.tdbasket.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EquipeDto {

    @NotBlank
    private String nom;

    @Override
    public String toString() {
        return "EquipeDto{" +
                "nom='" + nom + '\'' +
                '}';
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
