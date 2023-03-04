package br.com.woll.med.api.doctor.controller;

import br.com.woll.med.api.doctor.dto.DoctorDto;
import br.com.woll.med.api.doctor.dto.EditDoctorDto;
import br.com.woll.med.api.doctor.dto.ListAllDoctorsDto;
import br.com.woll.med.api.doctor.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/doctor")
@RequiredArgsConstructor
public class DoctorController {
  private final DoctorService doctorService;

  @PostMapping("/register")
  public ResponseEntity createNewDoctor(
      @RequestBody @Valid DoctorDto doctorDto,
      UriComponentsBuilder uriBuilder
  ) {
    return doctorService.createNewDoctor(doctorDto, uriBuilder);
  }

  @GetMapping("/find-all")
  public ResponseEntity<List<ListAllDoctorsDto>> listAllDoctors() {
    List<ListAllDoctorsDto> list = doctorService.findAll();
    return ResponseEntity.ok(list);
  }

  @GetMapping("/find-all-orderly")
  public ResponseEntity<Page<ListAllDoctorsDto>> listAllDoctorsWithSortingAndPagination(
      @PageableDefault(size = 10, sort = {"name"})
      Pageable pageable
  ) {
    Page<ListAllDoctorsDto> page = doctorService.findAllOrderly(pageable);
    return ResponseEntity.ok(page);
  }

  @GetMapping("/detail-doctor-data{id}")
  public ResponseEntity<DoctorDto> detailDoctorData(@RequestParam UUID id) {
    DoctorDto doctorDto = doctorService.detailData(id);
    return ResponseEntity.ok(doctorDto);
  }

  @PutMapping("/edit-doctor")
  @Transactional
  public ResponseEntity<DoctorDto> editDoctor(@RequestBody @Valid EditDoctorDto editDoctorDto) {
    DoctorDto doctorDto = doctorService.updateDoctor(editDoctorDto);
    return ResponseEntity.ok(doctorDto);
  }

  @DeleteMapping("/delete-doctor{id}")
  @Transactional
  public ResponseEntity<Void> deleteDoctor(@RequestParam UUID id) {
    doctorService.deleteDoctor(id);
    return ResponseEntity.noContent().build();
  }
}
