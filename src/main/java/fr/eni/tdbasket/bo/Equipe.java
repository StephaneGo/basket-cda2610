package fr.eni.tdbasket.bo;

import java.util.List;
import java.util.Objects;

//norme Javabean
// POJO - Martin Fowler Plain Old Java Object - Bon vieil objet java
public class Equipe {
    //Etat de l'objet
    private int noEquipe;
    private String nom;

    //Constructeurs
    public Equipe(int noEquipe, String nom){
        this.noEquipe = noEquipe;
        this.nom = nom;
    }

    public Equipe( String nom){
        this.nom = nom;
    }

    public Equipe( ){
    }

    public int getNoEquipe() {
        return noEquipe;
    }

    public void setNoEquipe(int noEquipe) {
        this.noEquipe = noEquipe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Equipe equipe = (Equipe) o;
        return noEquipe == equipe.noEquipe && Objects.equals(nom, equipe.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noEquipe, nom);
    }

    @Override
    public String toString() {
        return "Equipe{" +
                "noEquipe=" + noEquipe +
                ", nom='" + nom + '\'' +
                '}';
    }
}
