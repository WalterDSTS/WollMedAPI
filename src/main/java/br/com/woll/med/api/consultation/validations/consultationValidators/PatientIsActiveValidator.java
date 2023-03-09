package br.com.woll.med.api.consultation.validations.consultationValidators;

import br.com.woll.med.api.consultation.dto.ConsultationDto;
import br.com.woll.med.api.exception.ValidationException;
import br.com.woll.med.api.patient.model.Patient;
import br.com.woll.med.api.patient.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PatientIsActiveValidator implements ConsultationValidator {
  private final PatientRepository patientRepository;

  public void validate(ConsultationDto consultationDto) {
    Optional<Patient> patientIsActive = patientRepository.findByIdAndActiveTrue(consultationDto.getPatientId());

    if (!patientIsActive.isPresent()) {
      throw new ValidationException("Consultation cannot be scheduled with an inactive patient");
    }
  }
}
