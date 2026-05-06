package DTO;
import models.Dog;

public class DTOConverter<T,R> {

    public static Dog toEntity(DogDTO dogDTO) {
        return Dog.builder().id(dogDTO.getId()).name(dogDTO.getName())
                .type(dogDTO.getType()).build();
    }

    public static DogDTO toDTO(Dog dog) {
        return DogDTO.builder().id(dog.getId()).name(dog.getName())
                .type(dog.getType()).build();
    }
}
