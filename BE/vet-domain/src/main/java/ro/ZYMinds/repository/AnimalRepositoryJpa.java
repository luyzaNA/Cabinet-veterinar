package ro.ZYMinds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ZYMinds.entitity.Animal;

 public interface AnimalRepositoryJpa extends JpaRepository<Animal, Long> {
}
