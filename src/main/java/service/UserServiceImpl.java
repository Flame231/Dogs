package service;

import DTO.UserDTO;
import models.User;
import utils.EntityConverter;

import java.util.List;

public class UserServiceImpl implements UserService, EntityConverter<UserDTO, User> {


    @Override
    public UserDTO convertToDTO(User user) {
        return null;
    }

    @Override
    public User convertToEntity(UserDTO userDTO) {
        return null;
    }

    @Override
    public void register(String login, String passWord) {

    }

    @Override
    public void login(String login, String passWord) {

    }

    @Override
    public List<UserDTO> getAllUsers() {
        return List.of();
    }

    @Override
    public UserDTO findUserByLogin(String login) {
        return null;
    }

    @Override
    public UserDTO findUserById(Long id) {
        return null;
    }
}
