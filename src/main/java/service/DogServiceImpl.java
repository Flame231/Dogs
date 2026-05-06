package service;

import DAO.DogDAO;
import DAO.DogDAOImpl;
import DTO.DTOConverter;
import DTO.DogDTO;
import models.Dog;

import java.util.List;

public class DogServiceImpl implements DogService {
    DogDAO dogDAO = new DogDAOImpl();

    @Override
    public List<DogDTO> getAllDogs(int currentPage, int dogsPerPage) {
        List<Dog> dog = dogDAO.getAllDogs(currentPage, dogsPerPage);
        return dog.stream().map(DTOConverter::toDTO).toList();


    }

    @Override
    public Integer dogsCount() {
        return dogDAO.getDogsCount();
    }
}
