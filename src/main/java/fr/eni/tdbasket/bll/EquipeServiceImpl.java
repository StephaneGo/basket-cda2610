package fr.eni.tdbasket.bll;


import fr.eni.tdbasket.dal.EquipeRepository;
import org.springframework.stereotype.Service;

@Service
public class EquipeServiceImpl {

    private EquipeRepository equipeRepository;

    public EquipeServiceImpl(EquipeRepository equipeRepository){
        this.equipeRepository = equipeRepository;
    }


    //méthode métier qui renvoit la liste des équipes



}
