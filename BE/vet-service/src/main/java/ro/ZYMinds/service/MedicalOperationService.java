package ro.ZYMinds.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ro.ZYMinds.dto.MedicalOperationDto;
import ro.ZYMinds.entitity.MedicalOperation;
import ro.ZYMinds.repository.MedicalOperationRepository;

@Service
public class MedicalOperationService {

  private final MedicalOperationRepository medicalOperationRepository;

  public MedicalOperationService(MedicalOperationRepository medicalOperationRepository) {
    this.medicalOperationRepository = medicalOperationRepository;
  }

  public MedicalOperation findMedicalOperationById(Long id) {
          return medicalOperationRepository.findById(id);
  }

  @Transactional
  public Long saveMedicalOperation(MedicalOperationDto medicalOperationDto) {
    MedicalOperation medicalOperation = new MedicalOperation(
      medicalOperationDto.getName(),
      medicalOperationDto.getPrice()
    );
    medicalOperationRepository.save(medicalOperation);
    return medicalOperation.getId();
  }


}
