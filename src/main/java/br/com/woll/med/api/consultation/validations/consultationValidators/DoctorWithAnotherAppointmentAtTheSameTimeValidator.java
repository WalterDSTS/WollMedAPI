package br.com.woll.med.api.consultation.validations.consultationValidators;

import br.com.woll.med.api.consultation.dto.ConsultationDto;
import br.com.woll.med.api.consultation.repository.ConsultationRepository;
import br.com.woll.med.api.exception.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DoctorWithAnotherAppointmentAtTheSameTimeValidator implements ConsultationValidator {
  private final ConsultationRepository repository;

  public void validate(ConsultationDto consultationDto) {
    Boolean doctorHaveAnotherAppointmentAtTheSameTime =
        repository.existsByDoctorIdAndDate(consultationDto.getDoctorId(), consultationDto.getDate());

    if (doctorHaveAnotherAppointmentAtTheSameTime) {
      throw new ValidationException("Doctor already have another appointment at the same time");
    }
  }
}
