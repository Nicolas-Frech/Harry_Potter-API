package hogwarts.express.api_harry_potter.domain.spell;

public record SpellDTO(Long id, String name, String effect) {
    public SpellDTO(Spell spell) {
        this(spell.getId(), spell.getName(), spell.getEffect());
    }
}
