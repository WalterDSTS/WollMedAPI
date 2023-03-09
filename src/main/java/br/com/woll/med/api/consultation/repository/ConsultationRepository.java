package br.com.woll.med.api.consultation.repository;

import br.com.woll.med.api.consultation.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.UUID;

public interface ConsultationRepository extends JpaRepository<Consultation, UUID> {
  Boolean existsByDoctorIdAndDate(UUID doctorId, LocalDateTime date);

  Boolean existsByPatientIdAndDateBetween(UUID patientId, LocalDateTime firstHour, LocalDateTime lastHour);
}
