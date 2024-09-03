package hogwarts.express.api_harry_potter.domain.wizard;

public record WizardDTO(Long id, String name, String hogwartsHouse, String patronum, String birthdate) {
    public WizardDTO(Wizard wizard) {
        this(wizard.getId(), wizard.getName(), wizard.getHogwartsHouse(), wizard.getPatronum(), wizard.getBirthdate());
    }
}
