package ro.ZYMinds.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ro.ZYMinds.dto.AppointmentDto;
import ro.ZYMinds.entitity.*;
import ro.ZYMinds.repository.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    private final DoctorRepository doctorRepository;
    private final MedicalOperationRepository medicalOperationRepository;
    private final AppointmentRepository appointmentRepository;
    private final AnimalDiagnosticRepository animalDiagnosticRepository;

    public AppointmentService(AppointmentRepository appointmentRepository,
                              DoctorRepository doctorRepository,
                              MedicalOperationRepository medicalOperationRepository,
                              AnimalDiagnosticRepository animalDiagnosticRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.medicalOperationRepository = medicalOperationRepository;
        this.animalDiagnosticRepository = animalDiagnosticRepository;
    }

    @Transactional
    public Appointment findAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }


    @Transactional
    public Long saveAppointment(AppointmentDto appointmentDto) {
        Doctor doctor = doctorRepository.findById(appointmentDto.getDoctor().getId());

        List<MedicalOperation> services = appointmentDto.getServices().stream()
                .map(serviceDto -> medicalOperationRepository.findById(serviceDto.getId())).collect(Collectors.toList());
        AnimalDiagnostic diagnostic = null;

        String status = "creata";

        Appointment appointment = new Appointment(
                appointmentDto.getAnimalName(),
                doctor,
                services,
                diagnostic,
                appointmentDto.getAppointmentDateTime(),
                status
        );

        appointmentRepository.save(appointment);

        return appointment.getId();
    }

    @Transactional
    public void updateAppointment(Long appointmentId, AppointmentDto updatedAppointmentDto) {
        Appointment existingAppointment = appointmentRepository.findById(appointmentId);

        if (existingAppointment == null) {
            throw new IllegalArgumentException("Appointment not found with id: " + appointmentId);
        }
        existingAppointment.setAnimalName(updatedAppointmentDto.getAnimalName());
        Doctor doctor = doctorRepository.findById(updatedAppointmentDto.getDoctor().getId());
        existingAppointment.setDoctor(doctor);

        List<MedicalOperation> updatedServices = updatedAppointmentDto.getServices().stream()
                .map(serviceDto -> medicalOperationRepository.findById(serviceDto.getId()))
                .collect(Collectors.toList());
        existingAppointment.setServices(updatedServices);

        AnimalDiagnostic updatedDiagnostic = null;
        if (updatedAppointmentDto.getDiagnostic() != null) {
            updatedDiagnostic = animalDiagnosticRepository.findById(updatedAppointmentDto.getDiagnostic().getId());
            existingAppointment.setDiagnostic(updatedDiagnostic);

            existingAppointment.setStatus("incheiata");
        }
        appointmentRepository.update(existingAppointment);
    }
}
