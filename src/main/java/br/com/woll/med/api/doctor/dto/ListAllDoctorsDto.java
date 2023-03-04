package br.com.woll.med.api.doctor.dto;

import br.com.woll.med.api.doctor.enumeration.Expertise;
import br.com.woll.med.api.doctor.model.Doctor;
import lombok.Data;

import java.util.UUID;

@Data
public class ListAllDoctorsDto {
  private UUID id;
  private String name;
  private String email;
  private String crm;
  private Expertise expertise;

  public ListAllDoctorsDto(Doctor doctor) {
    this.id = doctor.getId();
    this.name = doctor.getName();
    this.email = doctor.getEmail();
    this.crm = doctor.getCrm();
    this.expertise = doctor.getExpertise();
  }
}
