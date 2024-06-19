package ro.ZYMinds;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ZYMinds.dto.MedicalOperationDto;
import ro.ZYMinds.entitity.MedicalOperation;
import ro.ZYMinds.service.MedicalOperationService;

import java.util.List;

@RestController
@RequestMapping("/operation")
public class MedicalOperationController {

  private final MedicalOperationService medicalOperationService;

  public MedicalOperationController(MedicalOperationService medicalOperationService) {
    this.medicalOperationService = medicalOperationService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<MedicalOperation> findMedicalOperationById(@PathVariable Long id) {
    MedicalOperation medicalOperation = medicalOperationService.findMedicalOperationById(id);
    if (medicalOperation != null) {
      return ResponseEntity.ok(medicalOperation);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public ResponseEntity<MedicalOperation> createMedicalOperation(@Valid @RequestBody MedicalOperationDto medicalOperationDto) {
    MedicalOperation medicalOperation = medicalOperationService.saveMedicalOperation(medicalOperationDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(medicalOperation);
  }
  @GetMapping
  public ResponseEntity<List<MedicalOperation>> getAllMedicalOperations() {
    List<MedicalOperation> medicalOperations = medicalOperationService.getAllMedicalOperations();
    return ResponseEntity.ok(medicalOperations);
  }
}
