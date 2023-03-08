package br.com.woll.med.api.patient.repository;

import br.com.woll.med.api.patient.model.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {
  Page<Patient> findAllByActiveTrue(Pageable pageable);
}
