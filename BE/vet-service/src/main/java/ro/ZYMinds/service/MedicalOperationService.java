package ro.ZYMinds.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ro.ZYMinds.dto.MedicalOperationDto;
import ro.ZYMinds.entitity.MedicalOperation;
import ro.ZYMinds.repository.MedicalOperationRepository;

import java.util.List;

@Service
public class MedicalOperationService {

  private final MedicalOperationRepository medicalOperationRepository;

  public MedicalOperationService(MedicalOperationRepository medicalOperationRepository) {
    this.medicalOperationRepository = medicalOperationRepository;
  }

  public MedicalOperation findMedicalOperationById(Long id) {
    return medicalOperationRepository.findById(id);
  }

  public MedicalOperation findMedicalOperationByName(String name) {
    return medicalOperationRepository.findByName(name);
  }

  @Transactional
  public MedicalOperation saveMedicalOperation(MedicalOperationDto medicalOperationDto) {
    String name = medicalOperationDto.getName();
    MedicalOperation existingMedicalOperation = findMedicalOperationByName(name);

    if (existingMedicalOperation != null) {
      throw new RuntimeException("A medical operation with the same name already exists: " + name);
    }

    MedicalOperation medicalOperation = new MedicalOperation(
            medicalOperationDto.getName(),
            medicalOperationDto.getPrice()
    );

    medicalOperationRepository.save(medicalOperation);
    return medicalOperation;
  }

  public List<MedicalOperation> getAllMedicalOperations() {
    return medicalOperationRepository.findAll();
  }
}
