package DAO;

import models.Dog;

import java.util.List;

public interface DogDAO extends DAO<Dog> {
    List<Dog> getAllDogs(int currentPage, int dogsPerPage);

    Integer getDogsCount();

}

