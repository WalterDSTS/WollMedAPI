package br.com.woll.med.api.consultation.dto;

import br.com.woll.med.api.doctor.enumeration.Expertise;
import lombok.Data;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ConsultationDto {
  private UUID doctorId;
  @NotNull
  private UUID patientId;
  @NotNull
  @Future
  private LocalDateTime date;
  private Expertise expertise;
}
