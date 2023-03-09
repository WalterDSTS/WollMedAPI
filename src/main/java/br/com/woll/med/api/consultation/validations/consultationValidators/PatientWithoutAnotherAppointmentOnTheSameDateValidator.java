package br.com.woll.med.api.consultation.validations.consultationValidators;

import br.com.woll.med.api.consultation.dto.ConsultationDto;
import br.com.woll.med.api.consultation.repository.ConsultationRepository;
import br.com.woll.med.api.exception.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class PatientWithoutAnotherAppointmentOnTheSameDateValidator implements ConsultationValidator {
  private final ConsultationRepository consultationRepository;

  public void validate(ConsultationDto consultationDto) {
    LocalDateTime firstHour = consultationDto.getDate().withHour(7);
    LocalDateTime lastHour = consultationDto.getDate().withHour(18);

    Boolean patientHaveAnotherAppointmentOnTheSameDate =
        consultationRepository.existsByPatientIdAndDateBetween(consultationDto.getPatientId(), firstHour, lastHour);

    if (patientHaveAnotherAppointmentOnTheSameDate) {
      throw new ValidationException("Consultation already have another appointment on the same date");
    }
  }
}
