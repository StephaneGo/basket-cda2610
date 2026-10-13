package fr.eni.tdbasket.controller;

import fr.eni.tdbasket.bll.EquipeService;
import fr.eni.tdbasket.bo.Equipe;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EquipeController {

    private EquipeService equipeService;

    public EquipeController(EquipeService equipeService){
        this.equipeService = equipeService;
    }

    @GetMapping("/equipes")
    public List<Equipe> findAllEquipes(){
        return equipeService.trouverEquipes();
    }


}
