package ro.ZYMinds;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ZYMinds.dto.AppointmentDto;
import ro.ZYMinds.entitity.Appointment;
import ro.ZYMinds.service.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

  private final AppointmentService appointmentService;

  public AppointmentController(AppointmentService appointmentService) {
    this.appointmentService = appointmentService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Appointment> findAppointmentById(@PathVariable Long id) {
    Appointment appointment = appointmentService.findAppointmentById(id);
    if (appointment != null) {
      return ResponseEntity.ok(appointment);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public ResponseEntity<Long> createAnimal(@Valid @RequestBody AppointmentDto appointmentDto) {
    Long appointmentId = appointmentService.saveAppointment(appointmentDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(appointmentId);
  }
  @PutMapping("/{id}")
  public ResponseEntity<Void> updateAppointment(@PathVariable Long id, @Valid @RequestBody AppointmentDto updatedAppointmentDto) {
    try {
      appointmentService.updateAppointment(id, updatedAppointmentDto);
      return ResponseEntity.ok().build();
    } catch (IllegalArgumentException e) {
      return ResponseEntity.notFound().build();
    }
  }
}
