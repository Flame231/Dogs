package DAO;

import DTO.UserDTO;
import models.User;

import java.util.List;

public interface UserDAO extends DAO<User>{
    void register (String login,String passWord);
    void login (String login,String passWord);
    List<User> getAllUsers();
    User findUserByLogin(String login);
    User findUserById(Long id);
}
