package br.com.woll.med.api.consultation.validations.consultationValidators;

import br.com.woll.med.api.consultation.dto.ConsultationDto;
import br.com.woll.med.api.doctor.model.Doctor;
import br.com.woll.med.api.doctor.repository.DoctorRepository;
import br.com.woll.med.api.exception.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DoctorIsActiveValidator implements ConsultationValidator {
  private final DoctorRepository repository;

  public void validate(ConsultationDto consultationDto) {
    //escolha do médico opcional
    if (consultationDto.getDoctorId() == null) {
      return;
    }

    Optional<Doctor> doctorIsActive = repository.findByIdAndActiveTrue(consultationDto.getDoctorId());

    if (!doctorIsActive.isPresent()) {
      throw new ValidationException("Consultation cannot be scheduled with an inactive doctor");
    }
  }
}
