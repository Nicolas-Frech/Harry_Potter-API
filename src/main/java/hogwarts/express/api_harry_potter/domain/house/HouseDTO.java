package hogwarts.express.api_harry_potter.domain.house;

public record HouseDTO(Long id, String name, String founder, String traits, String animal, String colors) {
    public HouseDTO(House house) {
        this(house.getId(), house.getName(), house.getFounder(), house.getTraits(), house.getAnimal(), house.getColors());
    }
}
