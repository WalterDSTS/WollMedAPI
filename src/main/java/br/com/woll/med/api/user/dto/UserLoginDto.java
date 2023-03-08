package br.com.woll.med.api.user.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserLoginDto {
  @NotBlank
  private String username;
  @NotBlank
  private String password;
}
