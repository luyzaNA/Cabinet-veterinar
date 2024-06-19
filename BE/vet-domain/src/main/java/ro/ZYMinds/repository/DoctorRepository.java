package ro.ZYMinds.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ro.ZYMinds.entitity.Doctor;

@Repository
public class DoctorRepository {

  @PersistenceContext
  private EntityManager em;

  public Doctor findById(Long id) {
    return em.find(Doctor.class, id);
  }

  public void save(Doctor doctor) {
    if (doctor.isTransient()) {
      em.persist(doctor);
    } else {
      em.merge(doctor);
    }
  }
}
