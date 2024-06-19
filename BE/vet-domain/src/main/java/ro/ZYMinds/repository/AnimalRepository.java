package ro.ZYMinds.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ro.ZYMinds.entitity.Animal;

@Repository
public class AnimalRepository {

  @PersistenceContext
  private EntityManager em;

  public Animal findById(Long id) {
    return em.find(Animal.class, id);
  }

  public void save(Animal animal) {
    if (animal.isTransient()) {
      em.persist(animal);
    } else {
      em.merge(animal);
    }
  }
}
