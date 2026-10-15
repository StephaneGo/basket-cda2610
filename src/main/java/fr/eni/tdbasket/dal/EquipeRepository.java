package fr.eni.tdbasket.dal;

import fr.eni.tdbasket.bo.Equipe;

import java.util.List;
import java.util.Optional;

public interface EquipeRepository {

    List<Equipe> findAllEquipes();

    Equipe saveEquipe(Equipe equipe);


    void deleteEquipeByNo(int noEquipe);


    Optional<Equipe> findByNom(String nom);

    void deleteEquipeByNom(String nom);
}
