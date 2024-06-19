package ro.ZYMinds.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import ro.ZYMinds.dto.AppointmentDto;
import ro.ZYMinds.entitity.*;
import ro.ZYMinds.repository.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class AppointmentService {


  private final AnimalRepository animalRepository;
  private final DoctorRepository doctorRepository;
  private final MedicalOperationRepository medicalOperationRepository;
  private final AppointmentRepository appointmentRepository;

  public AppointmentService(AppointmentRepository appointmentRepository,
                                   AnimalRepository animalRepository,
                                   DoctorRepository doctorRepository,
                                   MedicalOperationRepository medicalOperationRepository) {
    this.appointmentRepository = appointmentRepository;
    this.animalRepository = animalRepository;
    this.doctorRepository = doctorRepository;
    this.medicalOperationRepository = medicalOperationRepository;
  }

  @Transactional()
  public Appointment findAppointmentById(Long id) {
    return appointmentRepository.findById(id);
  }

  @Transactional
  public Long saveAppointment(AppointmentDto appointmentDto) {
    Optional<Animal> existingAnimal = Optional.ofNullable(animalRepository.findById(appointmentDto.getAnimal().getId()));
    Animal animal = existingAnimal.orElseGet(() -> {
      Animal newAnimal = new Animal(appointmentDto.getAnimal().getName());
      animalRepository.save(newAnimal);
      return newAnimal;
    });

    Doctor doctor = doctorRepository.findById(appointmentDto.getDoctor().getId());

    List<MedicalOperation> services = appointmentDto.getServices().stream()
      .map(serviceDto -> medicalOperationRepository.findById(serviceDto.getId())).collect(Collectors.toList());

    AnimalDiagnostic diagnostic = null;

    String status = "pending";

    Appointment appointment = new Appointment(animal, doctor, services, diagnostic, LocalDateTime.now(), status);
    appointmentRepository.save(appointment);

    return appointment.getId();
  }
}
