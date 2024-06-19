package ro.ZYMinds;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ZYMinds.dto.AnimalDto;
import ro.ZYMinds.entitity.Animal;
import ro.ZYMinds.service.AnimalService;

@RestController
@RequestMapping("/animal")
public class AnimalController {

  private final AnimalService animalService;

  public AnimalController(AnimalService animalService) {
    this.animalService = animalService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Animal> findAnimalById(@PathVariable Long id) {
    Animal animal = animalService.findAnimalById(id);
    if (animal != null) {
      return ResponseEntity.ok(animal);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public ResponseEntity<Long> createAnimal(@Valid @RequestBody AnimalDto animalDto) {
    Long animalId = animalService.saveAnimal(animalDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(animalId);
  }
}
