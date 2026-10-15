package fr.eni.tdbasket.exception;


//Exception personnalisée
public class EquipeNotFound  extends RuntimeException{
    int noEquipe;
    String nomEquipe;

    public EquipeNotFound(int noEquipe){
        super();
        this.noEquipe = noEquipe;
        this.nomEquipe = null;
    }

    public EquipeNotFound(String nomEquipe){
        super();
        this.noEquipe = 0;
        this.nomEquipe = nomEquipe;
    }

    @Override
    public String getMessage() {
        return this.nomEquipe!=null?"Equipe " + nomEquipe + " non trouvée":"Equipe no " + noEquipe + " non trouvée.";
    }
}
