package ro.ZYMinds.entitity;

import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "appointments")
public class Appointment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Version
  private Long version;

  @Column(name = "animal_name", nullable = false)
  private String animalName;

  @ManyToOne
  @JoinColumn(name = "doctor_id", nullable = false)
  private Doctor doctor;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
          name = "appointment_services",
          joinColumns = @JoinColumn(name = "appointment_id"),
          inverseJoinColumns = @JoinColumn(name = "service_id")
  )
  private List<MedicalOperation> services;

  @ManyToOne
  @JoinColumn(name = "diagnostic_id")
  private AnimalDiagnostic diagnostic;

  @Column(name = "appointment_date_time", nullable = false)
  private LocalDateTime appointmentDateTime;

  @Column(name = "status", length = 20, nullable = false)
  private String status;

  public Appointment() {
  }

  public Appointment(String animalName, Doctor doctor, List<MedicalOperation> services, AnimalDiagnostic diagnostic, LocalDateTime appointmentDateTime, String status) {
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


  public Long getVersion() {
    return version;
  }

  public String getAnimalName() {
    return animalName;
  }

  public void setAnimalName(String animalName) {
    this.animalName = animalName;
  }

  public Doctor getDoctor() {
    return doctor;
  }

  public void setDoctor(Doctor doctor) {
    this.doctor = doctor;
  }

  public List<MedicalOperation> getServices() {
    return services;
  }

  public void setServices(List<MedicalOperation> services) {
    this.services = services;
  }

  public AnimalDiagnostic getDiagnostic() {
    return diagnostic;
  }

  public void setDiagnostic(AnimalDiagnostic diagnostic) {
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

  public boolean isTransient() {
    return version == null;
  }
}
