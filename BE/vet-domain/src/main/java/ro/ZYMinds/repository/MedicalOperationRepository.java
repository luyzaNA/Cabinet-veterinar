package ro.ZYMinds.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ro.ZYMinds.entitity.MedicalOperation;

@Repository
public class MedicalOperationRepository {

  @PersistenceContext
  private EntityManager em;

  public MedicalOperation findById(Long id) {
    return em.find(MedicalOperation.class, id);
  }

  public void save(MedicalOperation medicalOperation) {
    if (medicalOperation.isTransient()) {
      em.persist(medicalOperation);
    } else {
      em.merge(medicalOperation);
    }
  }
}
