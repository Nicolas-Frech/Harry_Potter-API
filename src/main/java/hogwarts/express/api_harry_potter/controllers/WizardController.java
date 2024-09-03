package hogwarts.express.api_harry_potter.controllers;

import hogwarts.express.api_harry_potter.domain.wizard.Wizard;
import hogwarts.express.api_harry_potter.domain.wizard.WizardDTO;
import hogwarts.express.api_harry_potter.domain.wizard.WizardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bruxos")
public class WizardController {

    @Autowired
    private WizardRepository repository;

    @GetMapping
    public ResponseEntity searchWizards() {
        List<Wizard> wizards = repository.findAll();
        var wizardsListDTO = wizards.stream().map(WizardDTO::new).toList();

        return ResponseEntity.ok(wizardsListDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity searchWizardById(@PathVariable Long id) {
        var wizard = repository.getReferenceById(id);

        return ResponseEntity.ok(new WizardDTO(wizard));
    }

    @GetMapping("/nome/{name}")
    public ResponseEntity searchWizardByName(@PathVariable String name) {
        var wizard = repository.findByName(name.replace("+"," "));

        return ResponseEntity.ok(new WizardDTO(wizard));
    }

}

