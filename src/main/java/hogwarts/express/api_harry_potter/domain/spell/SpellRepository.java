package hogwarts.express.api_harry_potter.domain.spell;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SpellRepository extends JpaRepository<Spell, Long> {

    @Query("SELECT s FROM Spell s WHERE s.name LIKE %:name%")
    Spell findByName(String name);
}
