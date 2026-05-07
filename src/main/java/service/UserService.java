package service;

import DTO.UserDTO;
import exception.LoginAlreadyExists;
import exception.WrongPassword;

import java.util.List;

public interface UserService {
    void addUser(UserDTO userDTO);
    void updateUser(UserDTO userDTO,String newPass);
    void deleteUser(UserDTO userDTO);
    boolean register (String login,String passWord) throws LoginAlreadyExists;
    void login (String login,String passWord) throws NoSuchFieldException, WrongPassword;
    List<UserDTO> getAllUsers();
    UserDTO findUserByLogin(String login);
    UserDTO findUserById(Long id);

}
