package br.com.woll.med.api.consultation.service;

import br.com.woll.med.api.consultation.dto.ConsultationDto;
import br.com.woll.med.api.consultation.dto.ScheduleDetailsDto;

public interface ConsultationService {
  ScheduleDetailsDto schedule(ConsultationDto consultationDto);
}
