package br.com.woll.med.api.doctor.service;

import br.com.woll.med.api.doctor.dto.DoctorDto;
import br.com.woll.med.api.doctor.dto.EditDoctorDto;
import br.com.woll.med.api.doctor.dto.ListAllDoctorsDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;

public interface DoctorService {
  ResponseEntity createNewDoctor(DoctorDto doctorDto, UriComponentsBuilder uriBuilder);
  List<ListAllDoctorsDto> findAll();
  Page<ListAllDoctorsDto> findAllOrderly(Pageable pageable);
  DoctorDto detailData(UUID id);
  DoctorDto updateDoctor(EditDoctorDto editDoctorDto);
  void deleteDoctor(UUID id);
}
