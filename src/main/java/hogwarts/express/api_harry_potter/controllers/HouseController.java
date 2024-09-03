package hogwarts.express.api_harry_potter.controllers;

import hogwarts.express.api_harry_potter.domain.house.House;
import hogwarts.express.api_harry_potter.domain.house.HouseDTO;
import hogwarts.express.api_harry_potter.domain.house.HouseRepository;
import hogwarts.express.api_harry_potter.domain.wizard.WizardDTO;
import hogwarts.express.api_harry_potter.domain.wizard.WizardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/casas")
public class HouseController {

    @Autowired
    HouseRepository repository;

    @Autowired
    WizardRepository wizardRepository;

    @GetMapping
    public ResponseEntity searchHouses() {
        List<House> houses = repository.findAll();
        var housesListDTO = houses.stream().map(HouseDTO::new).toList();

        return ResponseEntity.ok(housesListDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity searchHouseById(@PathVariable Long id) {
        var house = repository.getReferenceById(id);

        return ResponseEntity.ok(new HouseDTO(house));
    }

    @GetMapping("/nome/{name}")
    public ResponseEntity searchHouseByName(@PathVariable String name) {
        var house = repository.findByName(name.replace("+"," "));

        return ResponseEntity.ok(new HouseDTO(house));
    }

    @GetMapping("/alunos/{house}")
    public ResponseEntity searchWizardsByHouse(@PathVariable String house) {
        var wizards = wizardRepository.findByHogwartsHouse(house);
        var wizardsDTO = wizards.stream().map(WizardDTO::new).toList();
        return ResponseEntity.ok(wizardsDTO);
    }
}
