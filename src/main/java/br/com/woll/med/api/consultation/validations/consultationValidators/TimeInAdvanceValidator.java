package br.com.woll.med.api.consultation.validations.consultationValidators;

import br.com.woll.med.api.consultation.dto.ConsultationDto;
import br.com.woll.med.api.exception.ValidationException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class TimeInAdvanceValidator implements ConsultationValidator {
  public void validate(ConsultationDto consultationDto) {
    LocalDateTime date = consultationDto.getDate();
    LocalDateTime now = LocalDateTime.now();
    Long diferenceInMinutes = Duration.between(now, date).toMinutes();

    if (diferenceInMinutes < 30) {
      throw new ValidationException("Consultation must be scheduled at least 30 minutes in advance");
    }
  }
}
