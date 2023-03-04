package br.com.woll.med.api.doctor.model;

import br.com.woll.med.api.address.model.Address;
import br.com.woll.med.api.doctor.enumeration.Expertise;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tbl_doctors")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Doctor {
  @Id @GeneratedValue
  private UUID id;
  private String name, email, phone, crm;
  @Enumerated(EnumType.STRING)
  private Expertise expertise;
  @Embedded
  private Address address;
  private Boolean active;
}


