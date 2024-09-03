package hogwarts.express.api_harry_potter.domain.wizard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface WizardRepository extends JpaRepository<Wizard, Long> {

    @Query("SELECT w FROM Wizard w WHERE w.name LIKE %:name%")
    Wizard findByName(String name);

    @Query("SELECT w FROM Wizard w WHERE w.hogwartsHouse LIKE %:house%")
    List<Wizard> findByHogwartsHouse(String house);
}
