package br.com.woll.med.api.doctor.controller;

import br.com.woll.med.api.doctor.dto.DoctorDto;
import br.com.woll.med.api.doctor.dto.EditDoctorDto;
import br.com.woll.med.api.doctor.dto.ListAllDoctorsDto;
import br.com.woll.med.api.doctor.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/doctor")
@RequiredArgsConstructor
public class DoctorController {
  private final DoctorService doctorService;

  @PostMapping("/register")
  public void createNewDoctor(@RequestBody @Valid DoctorDto doctorDto) {
    doctorService.createNewDoctor(doctorDto);
  }

  @GetMapping("/find-all")
  public List<ListAllDoctorsDto> listAllDoctors() {
    return doctorService.findAll();
  }

  @GetMapping("/find-all-orderly")
  public Page<ListAllDoctorsDto> listAllDoctorsWithSortingAndPagination(
      @PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
    return doctorService.findAllOrderly(pageable);
  }

  @PutMapping("/edit-doctor")
  @Transactional
  public void editDoctor(@RequestBody @Valid EditDoctorDto editDoctorDto) {
    doctorService.updateDoctor(editDoctorDto);
  }

  @DeleteMapping("/delete-doctor{id}")
  @Transactional
  public void deleteDoctor(@RequestParam UUID id) {
    doctorService.deleteDoctor(id);
  }
}
