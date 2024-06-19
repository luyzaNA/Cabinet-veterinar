package ro.ZYMinds.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ro.ZYMinds.dto.AnimalDto;
import ro.ZYMinds.entitity.Animal;
import ro.ZYMinds.repository.AnimalRepository;
import ro.ZYMinds.repository.AnimalRepositoryJpa;

@Service
public class AnimalService {

  private final AnimalRepository animalRepository;

  public AnimalService(AnimalRepository animalRepository) {
    this.animalRepository = animalRepository;
  }

  public Animal findAnimalById(Long id) {
    return animalRepository.findById(id);
  }

  @Transactional
  public Long saveAnimal(AnimalDto animalDto) {
    Animal animal = new Animal(animalDto.getName());
    animalRepository.save(animal);

    return animal.getId();
  }
}
