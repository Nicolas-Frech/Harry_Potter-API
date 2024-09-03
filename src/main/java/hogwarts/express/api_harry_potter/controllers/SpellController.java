package hogwarts.express.api_harry_potter.controllers;

import hogwarts.express.api_harry_potter.domain.spell.Spell;
import hogwarts.express.api_harry_potter.domain.spell.SpellDTO;
import hogwarts.express.api_harry_potter.domain.spell.SpellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/feiticos")
public class SpellController {

    @Autowired
    SpellRepository repository;

    @GetMapping
    public ResponseEntity searchSpells() {
        List<Spell> spells = repository.findAll();
        var spellsDTO = spells.stream().map(SpellDTO::new);

        return ResponseEntity.ok(spellsDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity searchSpellById(@PathVariable Long id) {
        var spell = repository.getReferenceById(id);

        return ResponseEntity.ok(new SpellDTO(spell));
    }

    @GetMapping("/nome/{name}")
    public ResponseEntity searchSpellByName(@PathVariable String name) {
        var spell = repository.findByName(name);

        return ResponseEntity.ok(new SpellDTO(spell));
    }
}
