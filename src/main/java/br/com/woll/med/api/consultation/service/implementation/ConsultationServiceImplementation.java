package br.com.woll.med.api.consultation.service.implementation;

import br.com.woll.med.api.consultation.dto.ConsultationDto;
import br.com.woll.med.api.consultation.dto.ScheduleDetailsDto;
import br.com.woll.med.api.consultation.model.Consultation;
import br.com.woll.med.api.consultation.repository.ConsultationRepository;
import br.com.woll.med.api.consultation.service.ConsultationService;
import br.com.woll.med.api.consultation.validations.consultationValidators.ConsultationValidator;
import br.com.woll.med.api.doctor.model.Doctor;
import br.com.woll.med.api.doctor.repository.DoctorRepository;
import br.com.woll.med.api.exception.ValidationException;
import br.com.woll.med.api.patient.model.Patient;
import br.com.woll.med.api.patient.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultationServiceImplementation implements ConsultationService {
  private final ConsultationRepository consultationRepository;
  private final DoctorRepository doctorRepository;
  private final PatientRepository patientRepository;
  private final List<ConsultationValidator> consultationValidators;

  public ScheduleDetailsDto schedule(ConsultationDto consultationDto) {
    if (!patientRepository.existsById(consultationDto.getPatientId())) {
      throw new ValidationException("Patient Id does not exist");
    }

    if (consultationDto.getDoctorId() != null && !doctorRepository.existsById(consultationDto.getDoctorId())) {
      throw new ValidationException("Doctor Id does not exist");
    }

    consultationValidators.forEach(validator -> validator.validate(consultationDto));

    Patient patient = patientRepository.getReferenceById(consultationDto.getPatientId());
    Doctor doctor = choseDoctor(consultationDto);

    Consultation consultation = new Consultation(null, doctor, patient, consultationDto.getDate());

    consultationRepository.save(consultation);

    return new ScheduleDetailsDto(consultation);
  }

  private Doctor choseDoctor(ConsultationDto consultationDto) {
    if (consultationDto.getDoctorId() != null) {
      return doctorRepository.getReferenceById(consultationDto.getDoctorId());
    }

    if (consultationDto.getExpertise() == null) {
      throw new ValidationException("Expertise is required when no doctor chosen");
    }

    return doctorRepository.chooseRandomDoctorFreeOnDate(
        consultationDto.getExpertise(), consultationDto.getDate()
    ).orElseThrow(() -> new ValidationException("There is no doctor available on this date"));
  }
}
