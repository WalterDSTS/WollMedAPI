package br.com.woll.med.api.patient.dto;

import br.com.woll.med.api.address.dto.AddressDto;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class EditPatientDto {
  @NotNull
  private UUID id;
  private String name;
  private String phone;
  private AddressDto addressDto;
}
