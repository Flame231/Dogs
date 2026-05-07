package service;

import DAO.UserDAO;
import DAO.UserDAOImpl;
import DTO.UserDTO;
import exception.LoginAlreadyExists;
import exception.UserNotFound;
import exception.WrongLogin;
import exception.WrongPassword;
import jakarta.persistence.NoResultException;
import lombok.extern.log4j.Log4j2;
import models.User;
import utils.EntityConverter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class UserServiceImpl implements UserService, EntityConverter<UserDTO, User> {

    private final UserDAO userDAO = new UserDAOImpl();

    @Override
    public UserDTO convertToDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .login(user.getLogin())
                .build();
    }

    @Override
    public User convertToEntity(UserDTO userDTO) {
        return User.builder()
                .id(userDTO.getId())
                .login(userDTO.getLogin())
                .build();
    }

    @Override
    public void addUser(UserDTO userDTO) {
        userDAO.save(convertToEntity(userDTO));
    }

    @Override
    public void updateUser(UserDTO userDTO, String newPass) throws UserNotFound {
        User user = userDAO.get(userDTO.getId());
        user.setLogin(userDTO.getLogin());
        user.setPassWord(newPass);
        userDAO.update(user);
    }

    @Override
    public void deleteUser(UserDTO userDTO) throws UserNotFound {
        userDAO.delete(convertToEntity(userDTO));
    }

    @Override
    public boolean register(String login, String passWord) throws LoginAlreadyExists {
        if (userDAO.findUserByLogin(login) != null) {
            log.warn("already exist with login {}",login);
            throw new LoginAlreadyExists("User already registered with this login");
        } else {
            User user = User.builder()
                    .login(login)
                    .passWord(PasswordHasher.hashPass(passWord))
                    .build();
            userDAO.save(user);
        }
        return true;
    }

    @Override
    public void login(String login, String passWord) throws WrongPassword,WrongLogin{
        try {
            User user = userDAO.findUserByLogin(login);
            if (user.getLogin().equals(login)) {
                if (PasswordHasher.checkPass(passWord, user.getPassWord())) {
                    log.info("successfully entered {}", user);
                } else {
                    log.warn("Wrong passWord {} by login {}", passWord, login);
                    throw new WrongPassword("Wrong Password");
                }
            }
        } catch (NoResultException e) {
            log.warn("Wrong login{}", login);
            throw new WrongLogin("Wrong login");
        }


    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userDAO.getAllUsers().stream().map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO findUserByLogin(String login) throws UserNotFound {
        try {
            return convertToDTO(userDAO.findUserByLogin(login));
        } catch (NoResultException e){
            log.warn("User with login {} not found",login);
            throw new UserNotFound("User with " + login + " not found",e);
        }
    }

    @Override
    public UserDTO findUserById(Long id) throws UserNotFound {
        try {
            return convertToDTO(userDAO.findUserById(id));
        } catch (NullPointerException e) {
            log.warn("User not founded by id {}",id);
            throw new UserNotFound("User not found by id");
        }

    }
}
