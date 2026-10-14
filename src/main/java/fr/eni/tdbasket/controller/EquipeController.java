package fr.eni.tdbasket.controller;

import fr.eni.tdbasket.bll.EquipeService;
import fr.eni.tdbasket.bo.Equipe;
import fr.eni.tdbasket.dto.EquipeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EquipeController {

    private EquipeService equipeService;

    public EquipeController(EquipeService equipeService){
        this.equipeService = equipeService;
    }

    @GetMapping("/equipes")
    public ResponseEntity<List<Equipe>> findAllEquipes(){
        List<Equipe> equipes = equipeService.trouverEquipes();
        return ResponseEntity.status(HttpStatus.OK)
                .body(equipes);
    }


    @PostMapping("/equipes")
    //public ResponseEntity<Equipe> addEquipe(@RequestParam(name = "nom") String nom){
    //public ResponseEntity<Equipe> addEquipe(@RequestParam String nom){
    public ResponseEntity<Equipe> addEquipe(@RequestBody EquipeDto equipeDto){

        System.out.println("nom: " + equipeDto.getNom());

        return null;
    }



}
