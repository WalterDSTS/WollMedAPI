package br.com.woll.med.api.consultation.validations.consultationValidators;

import br.com.woll.med.api.consultation.dto.ConsultationDto;

public interface ConsultationValidator {
  void validate(ConsultationDto consultationDto);
}
