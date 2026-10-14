package fr.eni.tdbasket.dal;

import fr.eni.tdbasket.bo.Equipe;

import java.util.List;

public interface EquipeRepository {

    List<Equipe> findAllEquipes();

    Equipe saveEquipe(Equipe equipe);

    void deleteEquipe(int noEquipe);
}
