package fr.eni.tdbasket.bll;


import fr.eni.tdbasket.bo.Equipe;
import fr.eni.tdbasket.dal.EquipeRepository;
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





}
