package br.com.woll.med.api.consultation.validations;

import br.com.woll.med.api.consultation.dto.ConsultationDto;
import br.com.woll.med.api.consultation.validations.consultationValidators.TimeInAdvanceValidator;
import br.com.woll.med.api.exception.ValidationException;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TimeInAdvanceValidatorTest {
  @Test
  public void shouldThrowExceptionWhenTimeIsLessThenThirtyMinutes() {
    ConsultationDto consultationDto = new ConsultationDto();
    LocalDateTime now = LocalDateTime.now().plusMinutes(29);
    consultationDto.setDate(now);
    TimeInAdvanceValidator timeInAdvanceValidator = new TimeInAdvanceValidator();
    assertThrows(ValidationException.class, () -> timeInAdvanceValidator.validate(consultationDto));
  }
}