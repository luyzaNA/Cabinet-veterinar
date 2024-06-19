package ro.ZYMinds.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ro.ZYMinds.dto.DoctorDto;
import ro.ZYMinds.entitity.Doctor;
import ro.ZYMinds.repository.DoctorRepository;

@Service
public class DoctorService {

  private final DoctorRepository doctorRepository;

  public DoctorService(DoctorRepository doctorRepository) {
    this.doctorRepository = doctorRepository;
  }

  public Doctor findDoctorById(Long id) {
    return doctorRepository.findById(id);
  }

  @Transactional
  public Long saveAnimal(DoctorDto doctorDto) {
    Doctor doctor = new Doctor(doctorDto.getName());
    doctorRepository.save(doctor);

    return doctor.getId();
  }
}
