package br.com.woll.med.api.consultation.model;

import br.com.woll.med.api.doctor.model.Doctor;
import br.com.woll.med.api.patient.model.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tbl_consultation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consultation {
  @Id
  @GeneratedValue
  private UUID id;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "doctor_id")
  private Doctor doctor;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "patient_id")
  private Patient patient;
  private LocalDateTime date;
}
