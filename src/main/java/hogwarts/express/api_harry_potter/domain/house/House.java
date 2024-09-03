package hogwarts.express.api_harry_potter.domain.house;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "House")
@Table(name = "houses")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String founder;

    private String traits;

    private String animal;

    private String colors;

    public House(String name) {
        this.name = name;
    }
}
