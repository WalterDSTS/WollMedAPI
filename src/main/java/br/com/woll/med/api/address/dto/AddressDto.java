package br.com.woll.med.api.address.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
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
