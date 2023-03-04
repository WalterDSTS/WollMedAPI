package br.com.woll.med.api.doctor.dto;

import br.com.woll.med.api.address.dto.AddressDto;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class EditDoctorDto {
  @NotNull
  private UUID id;
  private String name;
  private String phone;
  private AddressDto addressDto;
}
