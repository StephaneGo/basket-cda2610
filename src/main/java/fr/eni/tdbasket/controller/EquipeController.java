package fr.eni.tdbasket.controller;

import fr.eni.tdbasket.bll.EquipeService;
import fr.eni.tdbasket.bo.Equipe;
import fr.eni.tdbasket.dto.EquipeDto;
import fr.eni.tdbasket.exception.EquipeNotFound;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/equipes/find")
    public ResponseEntity<Equipe> findEquipeByNom(@RequestParam String nom){
        Optional<Equipe> equipe = equipeService.findByNom(nom);

        if(equipe.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(equipe.get());
    }


    @PostMapping("/equipes")
    //public ResponseEntity<Equipe> addEquipe(@RequestParam(name = "nom") String nom){
    //public ResponseEntity<Equipe> addEquipe(@RequestParam String nom){
    public ResponseEntity<Equipe> addEquipe(@Valid @RequestBody EquipeDto equipeDto, BindingResult bindingResult ){

        if(bindingResult.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        //System.out.println("nom: " + equipeDto.getNom());
        Equipe equipe = equipeService.ajouterEquipe(equipeDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(equipe);
    }


    @DeleteMapping("/equipes")
    public ResponseEntity<Void> supprimerEquipeParNumero(@RequestParam int noEquipe){
        try{
            equipeService.supprimerEquipe(noEquipe);
        }catch (EquipeNotFound enf){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @DeleteMapping("/equipes/{noEquipe}")
    public ResponseEntity<Void> supprimerEquipeParNumeroAvecPathVariable(
            @PathVariable int noEquipe){
        try{
            equipeService.supprimerEquipe(noEquipe);
        }catch (EquipeNotFound enf){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }




}
