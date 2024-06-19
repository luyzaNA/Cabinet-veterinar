package ro.ZYMinds.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ro.ZYMinds.entitity.MedicalOperation;

import java.util.List;

@Repository
public class MedicalOperationRepository {

  @PersistenceContext
  private EntityManager em;

  public MedicalOperation findById(Long id) {
    return em.find(MedicalOperation.class, id);
  }

  public MedicalOperation findByName(String name) {
    try {
      return em.createQuery("SELECT m FROM MedicalOperation m WHERE m.name = :name", MedicalOperation.class)
              .setParameter("name", name)
              .getSingleResult();
    } catch (NoResultException e) {
      return null;
    }
  }

  public void save(MedicalOperation medicalOperation) {
    if (medicalOperation.isTransient()) {
      em.persist(medicalOperation);
    } else {
      em.merge(medicalOperation);
    }
  }
  public List<MedicalOperation> findAll() {
    return em.createQuery("SELECT m FROM MedicalOperation m", MedicalOperation.class)
            .getResultList();
  }
}
