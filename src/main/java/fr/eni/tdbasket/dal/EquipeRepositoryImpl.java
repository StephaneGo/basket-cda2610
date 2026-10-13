package fr.eni.tdbasket.dal;

import fr.eni.tdbasket.bo.Equipe;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EquipeRepositoryImpl implements EquipeRepository{

    private List<Equipe> equipes;

    EquipeRepositoryImpl(){
        equipes = new ArrayList<>();

    }

    @Override
    public List<Equipe> findAllEquipes() {
        return equipes;
    }
}
