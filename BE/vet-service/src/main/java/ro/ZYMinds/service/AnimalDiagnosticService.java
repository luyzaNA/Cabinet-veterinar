package ro.ZYMinds.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ro.ZYMinds.dto.AnimalDiagnosticDto;
import ro.ZYMinds.entitity.AnimalDiagnostic;
import ro.ZYMinds.repository.AnimalDiagnosticRepository;

@Service
public class AnimalDiagnosticService {

    private  final AnimalDiagnosticRepository animalDiagnosticRepository;

    public AnimalDiagnosticService(AnimalDiagnosticRepository animalDiagnosticRepository) {
        this.animalDiagnosticRepository = animalDiagnosticRepository;
    }

    public AnimalDiagnostic findAnimalById(Long id) {
      return animalDiagnosticRepository.findById(id);
    }

    @Transactional
    public Long saveAnimal(AnimalDiagnosticDto animalDiagnosticDto) {
      AnimalDiagnostic animalDiagnostic = new AnimalDiagnostic(animalDiagnosticDto.getName(), animalDiagnosticDto.getDescription());
      animalDiagnosticRepository.save(animalDiagnostic);

      return animalDiagnostic.getId();
    }
}
