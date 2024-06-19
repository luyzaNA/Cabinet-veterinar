package ro.ZYMinds.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ro.ZYMinds.entitity.AnimalDiagnostic;


@Repository
public class AnimalDiagnosticRepository {

  @PersistenceContext
  private EntityManager em;

  public AnimalDiagnostic findById(Long id) {
    return em.find(AnimalDiagnostic.class, id);
  }

  public void save(AnimalDiagnostic diagnostic) {
    if (diagnostic.isTransient()) {
      em.persist(diagnostic);
    } else {
      em.merge(diagnostic);
    }
  }
}
