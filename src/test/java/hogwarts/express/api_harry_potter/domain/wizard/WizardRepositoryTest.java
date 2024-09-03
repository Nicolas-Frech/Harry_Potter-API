package hogwarts.express.api_harry_potter.domain.wizard;

import hogwarts.express.api_harry_potter.domain.house.House;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class WizardRepositoryTest {

    @Autowired
    EntityManager em;

    @Autowired
    WizardRepository wizardRepository;

    @Test
    @DisplayName("Deve retornar null se não tem nenhum bruxo nessa cadastrado na casa escolhida")
    void findByHogwartsHouse_cenario1() {
        //given ou arrange
        var wizard = registerWizard("Nome", "Grifinória", "Cervo", "03/052001");
        var house = "Sonserina";

        //when ou act
        var wizardHouse = wizardRepository.findByHogwartsHouse(house);

        //then ou assert
        assertThat(wizardHouse).isNotEqualTo(wizard.getHogwartsHouse());
    }

    private Wizard registerWizard(String name, String hogwartsHouse, String patronum, String birthdate) {
        var wizard = new Wizard(name, hogwartsHouse, patronum, birthdate);
        em.persist(wizard);
        return wizard;
    }
}