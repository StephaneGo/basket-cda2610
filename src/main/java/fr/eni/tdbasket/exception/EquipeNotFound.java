package fr.eni.tdbasket.exception;


//Exception personnalisée
public class EquipeNotFound  extends RuntimeException{
    int noEquipe;

    public EquipeNotFound(int noEquipe){
        super();
        this.noEquipe = noEquipe;
    }

    @Override
    public String getMessage() {
        return "Equipe no " + noEquipe + " non trouvée.";
    }
}
