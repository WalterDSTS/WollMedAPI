package br.com.woll.med.api.doctor.dto;

import br.com.woll.med.api.address.dto.AddressDto;
import br.com.woll.med.api.doctor.enumeration.Expertise;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorDto {
  @JsonIgnore
  private UUID id;
  @NotNull
  @NotBlank
  private String name;
  @Email
  @NotBlank
  private String email;
  @NotBlank
  private String phone;
  @NotBlank
  @Pattern(regexp = "\\d{4,6}")
  private String crm;
  @NotNull
  private Expertise expertise;
  @NotNull
  @Valid
  private AddressDto addressDto;
  @JsonIgnore
  private Boolean active = true;
}
