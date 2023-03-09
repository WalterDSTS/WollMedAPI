package br.com.woll.med.api.consultation.validations.consultationValidators;

import br.com.woll.med.api.consultation.dto.ConsultationDto;
import br.com.woll.med.api.exception.ValidationException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Component
public class ClinicWorkingHoursValidator implements ConsultationValidator {
  public void validate(ConsultationDto consultationDto) {
    LocalDateTime date = consultationDto.getDate();

    Boolean sunday = date.getDayOfWeek().equals(DayOfWeek.SUNDAY);
    Boolean beforeTheClinicOpens = date.getHour() < 7;
    Boolean afterTheClinicOpens = date.getHour() > 18;

    if (sunday || beforeTheClinicOpens || afterTheClinicOpens) {
      throw new ValidationException("Consultation outside clinic opening hours");
    }
  }
}
