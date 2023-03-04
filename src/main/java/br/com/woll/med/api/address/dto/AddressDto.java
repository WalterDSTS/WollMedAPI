package br.com.woll.med.api.address.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDto {
  @NotBlank
  private String street;
  @NotBlank
  private String number;
  @NotBlank
  private String neighborhood;
  @NotBlank
  private String city;
  @NotBlank
  private String uf;
  @NotBlank
  @Pattern(regexp = "\\d{8}")
  private String cep;
  private String complement;
}
