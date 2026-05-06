package DAO;

import DTO.UserDTO;
import jakarta.persistence.EntityNotFoundException;

import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;

public class UserDAOImpl extends DAOImpl<User> implements UserDAO {
    public UserDAOImpl() {
        super(User.class);
    }
    private static final Logger log = LogManager.getLogger(UserDAOImpl.class);


    @Override
    public void register(String login, String passWord) {

    }

    @Override
    public void login(String login, String passWord) {

    }

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("from User ", User.class).getResultList();
    }

    @Override
    public User findUserByLogin(String login) {
        try {
            return em.createQuery("from User user where user.login=: login", User.class)
            .setParameter("login", login).getSingleResult();
        } catch (NoResultException e) {
            log.warn("User with login {} not found",login);
            return null;
        }
    }

    @Override
    public User findUserById(Long id) {
        return null;
    }
}
