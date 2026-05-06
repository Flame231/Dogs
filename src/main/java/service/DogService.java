package service;

import DTO.DogDTO;

import java.util.List;

public interface DogService {
    List<DogDTO> getAllDogs(int currentPage, int dogsPerPage);

    Integer dogsCount();


}
