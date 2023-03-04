package br.com.woll.med.api.doctor.repository;

import br.com.woll.med.api.doctor.model.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DoctorRepository extends JpaRepository<Doctor, UUID> {
  Page<Doctor> findAllByActiveTrue(Pageable pageable);
}
