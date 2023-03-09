package br.com.woll.med.api.doctor.repository;

import br.com.woll.med.api.doctor.enumeration.Expertise;
import br.com.woll.med.api.doctor.model.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DoctorRepository extends JpaRepository<Doctor, UUID> {
  Page<Doctor> findAllByActiveTrue(Pageable pageable);

  @Query(
      "select d from Doctor d " +
      "where d.active = true " +
      "and d.expertise = :expertise " +
      "and d not in(" +
        "select c.doctor from Consultation c " +
        "where c.date = :date" +
      ") " +
      "order by rand()"
  )
  List<Doctor> findRandomDoctorFreeOnDate(Expertise expertise, LocalDateTime date, Pageable pageable);

  default Optional<Doctor> chooseRandomDoctorFreeOnDate(Expertise expertise, LocalDateTime date) {
    List<Doctor> doctors = findRandomDoctorFreeOnDate(expertise, date, PageRequest.of(0, 1));
    return doctors.isEmpty() ? Optional.empty() : Optional.of(doctors.get(0));
  }

  Optional<Doctor> findByIdAndActiveTrue(UUID doctorId);
}
