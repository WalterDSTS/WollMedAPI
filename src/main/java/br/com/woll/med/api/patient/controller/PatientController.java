package br.com.woll.med.api.patient.controller;

import br.com.woll.med.api.patient.dto.EditPatientDto;
import br.com.woll.med.api.patient.dto.ListAllPatientsDto;
import br.com.woll.med.api.patient.dto.PatientDto;
import br.com.woll.med.api.patient.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/patient")
@RequiredArgsConstructor
public class PatientController {
  private final PatientService patientService;

  @PostMapping("/register")
  public ResponseEntity createNewPatient(
      @RequestBody
      @Valid
      PatientDto patientDto,
      UriComponentsBuilder uriBuilder
  ) {
    return patientService.createNewPatient(patientDto, uriBuilder);
  }

  @GetMapping("/find-all")
  public ResponseEntity<Page<ListAllPatientsDto>> listAllPatients(
      @PageableDefault(size = 10, sort = {"name"})
      Pageable pageable
  ) {
    Page<ListAllPatientsDto> list = patientService.findAll(pageable);
    return ResponseEntity.ok(list);
  }

  @PutMapping("/edit-patient")
  @Transactional
  public ResponseEntity<PatientDto> editPatient(@RequestBody @Valid EditPatientDto editPatientDto) {
    PatientDto patientDto = patientService.updatePatient(editPatientDto);
    return ResponseEntity.ok(patientDto);
  }

  @DeleteMapping("/delete-patient{id}")
  @Transactional
  public ResponseEntity<Void> deletePatient(@RequestParam UUID id) {
    patientService.deletePatient(id);
    return ResponseEntity.noContent().build();
  }
}
