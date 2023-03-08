package br.com.woll.med.api.patient.model;

import br.com.woll.med.api.address.model.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tbl_patient")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Patient {
  @Id
  @GeneratedValue
  private UUID id;
  private String name;
  private String cpf;
  private String phone;
  private String email;
  @Embedded
  private Address address;
  private Boolean active;
}
