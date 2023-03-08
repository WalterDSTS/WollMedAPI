package br.com.woll.med.api.patient.service;

import br.com.woll.med.api.patient.dto.EditPatientDto;
import br.com.woll.med.api.patient.dto.ListAllPatientsDto;
import br.com.woll.med.api.patient.dto.PatientDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

public interface PatientService {
  ResponseEntity createNewPatient(PatientDto patientDto, UriComponentsBuilder uriBuilder);
  Page<ListAllPatientsDto> findAll(Pageable pageable);
  PatientDto updatePatient(EditPatientDto editPatientDto);
  void deletePatient(UUID id);
}
