package br.com.woll.med.api.doctor.service;

import br.com.woll.med.api.doctor.dto.DoctorDto;
import br.com.woll.med.api.doctor.dto.EditDoctorDto;
import br.com.woll.med.api.doctor.dto.ListAllDoctorsDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface DoctorService {
  void createNewDoctor(DoctorDto doctorDto);
  List<ListAllDoctorsDto> findAll();
  Page<ListAllDoctorsDto> findAllOrderly(Pageable pageable);
  void updateDoctor(EditDoctorDto editDoctorDto);
  void deleteDoctor(UUID id);
}
