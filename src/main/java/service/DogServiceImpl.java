package service;

import DAO.DogDAO;
import DAO.DogDAOImpl;
import DTO.DTOConverter;
import DTO.DogDTO;
import models.Dog;
import utils.EntityConverter;

import java.util.List;

public class DogServiceImpl implements DogService, EntityConverter<DogDTO,Dog> {
    private final DogDAO dogDAO = new DogDAOImpl();

    @Override
    public List<DogDTO> getAllDogs(int currentPage, int dogsPerPage) {
        List<Dog> dog = dogDAO.getAllDogs(currentPage, dogsPerPage);
        return dog.stream().map(this::convertToDTO).toList();
    }

    @Override
    public Integer dogsCount() {
        return dogDAO.getDogsCount();
    }

    @Override
    public DogDTO convertToDTO(Dog dog) {
        return DogDTO.builder()
                .id(dog.getId())
                .name(dog.getName())
                .type(dog.getType())
                .build();
    }

    @Override
    public Dog convertToEntity(DogDTO dogDTO) {
        return null;
    }
}
