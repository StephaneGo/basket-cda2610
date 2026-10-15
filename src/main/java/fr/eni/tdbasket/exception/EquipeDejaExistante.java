package fr.eni.tdbasket.exception;

public class EquipeDejaExistante extends RuntimeException {

    public EquipeDejaExistante(String nomEquipe) {
        super("L'equipe " + nomEquipe + " existe déjà.");
    }
}
