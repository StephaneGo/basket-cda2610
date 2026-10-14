package fr.eni.tdbasket.bll;


import fr.eni.tdbasket.bo.Equipe;
import fr.eni.tdbasket.dal.EquipeRepository;
import fr.eni.tdbasket.dto.EquipeDto;
import fr.eni.tdbasket.exception.EquipeNotFound;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipeServiceImpl implements EquipeService {

    private EquipeRepository equipeRepository;

    public EquipeServiceImpl(EquipeRepository equipeRepository){
        this.equipeRepository = equipeRepository;
    }

    //méthode métier qui renvoit la liste des équipes
    @Override
    public List<Equipe> trouverEquipes() {
        List<Equipe> equipes = equipeRepository.findAllEquipes();
        return equipes;
    }

    @Override
    public Equipe ajouterEquipe(EquipeDto nouvelleEquipe){
        // Transformation du DTO en BO
        //Equipe newEquipe = new Equipe(nouvelleEquipe.getNom());
        Equipe newEquipe = new Equipe();
        BeanUtils.copyProperties(nouvelleEquipe, newEquipe);

        return equipeRepository.saveEquipe(newEquipe);
    }

    @Override
    public void supprimerEquipe(int noEquipe)  {
        equipeRepository.deleteEquipe(noEquipe);
    }

}
