package br.com.woll.med.api.patient.dto;

import br.com.woll.med.api.address.dto.AddressDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientDto {
  @JsonIgnore
  private UUID id;
  @NotNull
  @NotBlank
  private String name;
  @NotNull
  @NotBlank
  private String cpf;
  @Email
  @NotBlank
  private String email;
  @NotBlank
  private String phone;
  @NotNull
  @Valid
  private AddressDto addressDto;
  @JsonIgnore
  private Boolean active = true;
}
