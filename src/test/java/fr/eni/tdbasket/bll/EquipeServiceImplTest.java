package fr.eni.tdbasket.bll;

import fr.eni.tdbasket.bo.Equipe;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class EquipeServiceImplTest {

    @Autowired
    private EquipeService equipeService;

    @Test
    @DisplayName("test de récupération des équipes cas droit")
    public void testRecuperationDesEquipes(){
        //AAA
        //Arrange

        //Act=Agir=tester
        List<Equipe> equipes = equipeService.trouverEquipes();

        //Assert=Vérifier
        assertThat(equipes).isNotNull();
        assertThat(equipes.size()).isEqualTo(1);

    }


}
