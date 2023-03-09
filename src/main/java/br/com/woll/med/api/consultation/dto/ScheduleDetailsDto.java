package br.com.woll.med.api.consultation.dto;

import br.com.woll.med.api.consultation.model.Consultation;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ScheduleDetailsDto {
  private UUID id;
  private UUID doctorId;
  private UUID patientId;
  private LocalDateTime date;

  public ScheduleDetailsDto(Consultation consultation) {
    this.id = consultation.getId();
    this.doctorId = consultation.getDoctor().getId();
    this.patientId = consultation.getPatient().getId();
    this.date = consultation.getDate();
  }
}
