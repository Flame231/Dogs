package DAO;

import exception.UserNotFound;
import jakarta.persistence.NoResultException;
import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class UserDAOImpl extends DAOImpl<User> implements UserDAO {
    public UserDAOImpl() {
        super(User.class);
    }

    private static final Logger log = LogManager.getLogger(UserDAOImpl.class);



    @Override
    public List<User> getAllUsers() {
        return em.createQuery("from User ", User.class).getResultList();
    }

    @Override
    public User findUserByLogin(String login) throws NoResultException{
            return em.createQuery("from User user where user.login=: login", User.class)
                    .setParameter("login", login).getSingleResult();
    }

    @Override
    public User findUserById(Long id) throws NullPointerException{
        User user = get(id);
        if (user == null) {
            log.warn("User with id {} not found", id);
            return null;
        } else
            return user;
    }
}
