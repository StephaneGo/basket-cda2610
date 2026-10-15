package fr.eni.tdbasket.bll;

import fr.eni.tdbasket.bo.Equipe;
import fr.eni.tdbasket.dto.EquipeDto;

import java.util.List;
import java.util.Optional;

public interface EquipeService {

    List<Equipe> trouverEquipes();

    Optional<Equipe> findByNom(String nom);

    Equipe ajouterEquipe(EquipeDto nouvelleEquipe);

    void supprimerEquipe(int noEquipe);
}
