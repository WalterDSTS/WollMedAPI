package br.com.woll.med.api.patient.dto;

import br.com.woll.med.api.patient.model.Patient;
import lombok.Data;

import java.util.UUID;

@Data
public class ListAllPatientsDto {
  private UUID id;
  private String name;
  private String email;
  private String cpf;

  public ListAllPatientsDto(Patient patient) {
    this.id = patient.getId();
    this.name = patient.getName();
    this.email = patient.getEmail();
    this.cpf = patient.getCpf();
  }
}
