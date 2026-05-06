package service;

import DTO.UserDTO;

import java.util.List;

public interface UserService {
    void register (String login,String passWord);
    void login (String login,String passWord);
    List<UserDTO> getAllUsers();
    UserDTO findUserByLogin(String login);
    UserDTO findUserById(Long id);

}
