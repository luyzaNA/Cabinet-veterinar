package ro.ZYMinds.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ro.ZYMinds.entitity.Appointment;

@Repository
public class AppointmentRepository {

  @PersistenceContext
  private EntityManager em;

  public Appointment findById(Long id) {
    return em.find(Appointment.class, id);
  }

  public void save(Appointment appointment) {
    if (appointment.isTransient()) {
      em.persist(appointment);
    } else {
      em.merge(appointment);
    }
  }
}


