package ro.ZYMinds.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ro.ZYMinds.entitity.User;

@Repository
public class UserRepository {

  @PersistenceContext
  private EntityManager em;

  public void save(User user) {
    if (user.isTransient()) {
      em.persist(user);
    } else {
      em.merge(user);
    }
  }

  public User findByEmail(String email) {
    return em.find(User.class, email);
  }

}
