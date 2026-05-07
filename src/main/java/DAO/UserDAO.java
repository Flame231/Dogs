package DAO;

import DTO.UserDTO;
import exception.UserNotFound;
import models.User;

import java.util.List;

public interface UserDAO extends DAO<User>{
    List<User> getAllUsers();
    User findUserByLogin(String login);
    User findUserById(Long id) throws UserNotFound;
}
