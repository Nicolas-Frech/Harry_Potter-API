package hogwarts.express.api_harry_potter.domain.wizard;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Wizard")
@Table(name = "wizards")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Wizard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String hogwartsHouse;

    private String patronum;

    private String birthdate;

    public Wizard(String name, String hogwartsHouse, String patronum, String birthdate){
        this.name = name;
        this.hogwartsHouse = hogwartsHouse;
        this.patronum = patronum;
        this.birthdate = birthdate;
    }
}
