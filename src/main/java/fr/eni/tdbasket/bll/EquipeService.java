package fr.eni.tdbasket.bll;

import fr.eni.tdbasket.bo.Equipe;
import fr.eni.tdbasket.dto.EquipeDto;

import java.util.List;

public interface EquipeService {

    List<Equipe> trouverEquipes();

    Equipe ajouterEquipe(EquipeDto nouvelleEquipe);

}
