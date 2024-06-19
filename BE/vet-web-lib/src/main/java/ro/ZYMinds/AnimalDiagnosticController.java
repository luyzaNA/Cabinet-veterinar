package ro.ZYMinds;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ZYMinds.dto.AnimalDiagnosticDto;
import ro.ZYMinds.entitity.AnimalDiagnostic;
import ro.ZYMinds.service.AnimalDiagnosticService;

@RestController
@RequestMapping("/diagnostic")
public class AnimalDiagnosticController {

  private final AnimalDiagnosticService animalDiagnosticService;

  public AnimalDiagnosticController(AnimalDiagnosticService animalDiagnosticService) {
    this.animalDiagnosticService = animalDiagnosticService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<AnimalDiagnostic> findAnimalById(@PathVariable Long id) {
    AnimalDiagnostic animalDiagnostic = animalDiagnosticService.findAnimalById(id);
    if (animalDiagnostic != null) {
      return ResponseEntity.ok(animalDiagnostic);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public ResponseEntity<Long> createAnimalDiagnostic(@Valid @RequestBody AnimalDiagnosticDto animalDiagnosticDto) {
    Long animalDiagnosticId = animalDiagnosticService.saveAnimal(animalDiagnosticDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(animalDiagnosticId);
  }
}
