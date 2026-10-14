package fr.eni.tdbasket.dal;

import fr.eni.tdbasket.bo.Equipe;
import fr.eni.tdbasket.exception.EquipeNotFound;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EquipeRepositoryImpl implements EquipeRepository{

    private List<Equipe> equipes;

    private static int compteurEquipe =0;

    EquipeRepositoryImpl(){
        equipes = new ArrayList<>();

    }

    @Override
    public List<Equipe> findAllEquipes() {
        return equipes;
    }

    @Override
    public Equipe saveEquipe(Equipe equipe){
        compteurEquipe++;
        equipe.setNoEquipe(compteurEquipe);
        equipes.add(equipe);
        return equipe;
    }

    @Override
    public void deleteEquipe(int noEquipe)
    {
        Optional<Equipe> optEquipe = equipes.stream().filter(equipe -> equipe.getNoEquipe()==noEquipe).findFirst();

        if(optEquipe.isEmpty()){
            throw new EquipeNotFound(noEquipe);
        }

        equipes.remove(optEquipe.get());
    }
}
