package hogwarts.express.api_harry_potter.domain.house;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HouseRepository extends JpaRepository<House, Long> {

    @Query("SELECT h FROM House h WHERE h.name LIKE %:name%")
    House findByName(String name);
}
