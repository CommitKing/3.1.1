package springBoot.SpringBootApp.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import springBoot.SpringBootApp.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public void update(User user) {
        if (findById(user.getId()) == null) {
            throw new EntityNotFoundException("User with ID " + user.getId() + " not found for update.");
        }
        em.merge(user);
    }

    @Override
    public void delete(User user) {
        if (findById(user.getId()) == null) {
            throw new EntityNotFoundException("User with ID " + user.getId() + " not found for deletion.");
        }
        em.remove(em.contains(user) ? user : em.merge(user));
    }

    @Override
    public User findById(int id) {
        User user = em.find(User.class, id);
        if (user == null) {
            throw new EntityNotFoundException("User with ID " + id + " not found.");
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }
}
