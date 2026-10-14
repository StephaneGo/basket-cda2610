package fr.eni.tdbasket.dto;

public class EquipeDto {

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
