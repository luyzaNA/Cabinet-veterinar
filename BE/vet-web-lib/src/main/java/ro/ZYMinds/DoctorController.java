package ro.ZYMinds;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ZYMinds.dto.DoctorDto;
import ro.ZYMinds.entitity.Doctor;
import ro.ZYMinds.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

  private final DoctorService doctorService;

  public DoctorController(DoctorService doctorService) {
    this.doctorService = doctorService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Doctor> findAnimalById(@PathVariable Long id) {
    Doctor doctor = doctorService.findDoctorById(id);
    if (doctor != null) {
      return ResponseEntity.ok(doctor);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public ResponseEntity<Long> createAnimal(@Valid @RequestBody DoctorDto doctorDto) {
    Long doctorId = doctorService.saveAnimal(doctorDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(doctorId);
  }
}
