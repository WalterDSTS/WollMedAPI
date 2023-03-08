package br.com.woll.med.api.patient.mapper;

import br.com.woll.med.api.address.dto.AddressDto;
import br.com.woll.med.api.address.mapper.AddressMapper;
import br.com.woll.med.api.address.model.Address;
import br.com.woll.med.api.patient.dto.PatientDto;
import br.com.woll.med.api.patient.model.Patient;

public class PatientMapper {
  public static Patient toPatient(PatientDto patientDto) {
    Address address = AddressMapper.toAddress(patientDto.getAddressDto());

    return Patient
        .builder()
        .name(patientDto.getName())
        .cpf(patientDto.getCpf())
        .email(patientDto.getEmail())
        .phone(patientDto.getPhone())
        .address(address)
        .active(patientDto.getActive())
        .build();
  }

  public static PatientDto toPatientDto(Patient patient) {
    AddressDto addressDto = AddressMapper.toAddressDto(patient.getAddress());

    return PatientDto
        .builder()
        .name(patient.getName())
        .cpf(patient.getCpf())
        .email(patient.getEmail())
        .phone(patient.getPhone())
        .addressDto(addressDto)
        .active(patient.getActive())
        .build();
  }
}
