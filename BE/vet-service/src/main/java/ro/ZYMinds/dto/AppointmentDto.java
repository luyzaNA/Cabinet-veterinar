package ro.ZYMinds.dto;

import java.time.LocalDateTime;
import java.util.List;

public class AppointmentDto {

  private Long id;
  private String animalName;
  private DoctorDto doctor;
  private List<MedicalOperationDto> services;
  private AnimalDiagnosticDto diagnostic;
  private LocalDateTime appointmentDateTime;
  private String status;

  public AppointmentDto() {
  }

  public AppointmentDto(Long id, String animalName, DoctorDto doctor, List<MedicalOperationDto> services, AnimalDiagnosticDto diagnostic, LocalDateTime appointmentDateTime, String status) {
    this.id = id;
    this.animalName = animalName;
    this.doctor = doctor;
    this.services = services;
    this.diagnostic = diagnostic;
    this.appointmentDateTime = appointmentDateTime;
    this.status = status;
  }
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAnimalName() {
    return animalName;
  }

  public void setAnimalName(String animalName) {
    this.animalName = animalName;
  }

  public DoctorDto getDoctor() {
    return doctor;
  }

  public void setDoctor(DoctorDto doctor) {
    this.doctor = doctor;
  }

  public List<MedicalOperationDto> getServices() {
    return services;
  }

  public void setServices(List<MedicalOperationDto> services) {
    this.services = services;
  }

  public AnimalDiagnosticDto getDiagnostic() {
    return diagnostic;
  }

  public void setDiagnostic(AnimalDiagnosticDto diagnostic) {
    this.diagnostic = diagnostic;
  }

  public LocalDateTime getAppointmentDateTime() {
    return appointmentDateTime;
  }

  public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
    this.appointmentDateTime = appointmentDateTime;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}

