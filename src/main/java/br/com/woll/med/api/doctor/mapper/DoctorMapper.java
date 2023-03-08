package br.com.woll.med.api.doctor.mapper;

import br.com.woll.med.api.address.dto.AddressDto;
import br.com.woll.med.api.address.mapper.AddressMapper;
import br.com.woll.med.api.address.model.Address;
import br.com.woll.med.api.doctor.dto.DoctorDto;
import br.com.woll.med.api.doctor.model.Doctor;

public class DoctorMapper {
  public static Doctor toDoctor(DoctorDto doctorDto) {
    Address address = AddressMapper.toAddress(doctorDto.getAddressDto());

    return Doctor
        .builder()
        .name(doctorDto.getName())
        .email(doctorDto.getEmail())
        .phone(doctorDto.getPhone())
        .crm(doctorDto.getCrm())
        .expertise(doctorDto.getExpertise())
        .address(address)
        .active(doctorDto.getActive())
        .build();
  }

  public static DoctorDto toDoctorDto(Doctor doctor) {
    AddressDto addressDto = AddressMapper.toAddressDto(doctor.getAddress());

    return DoctorDto
        .builder()
        .name(doctor.getName())
        .email(doctor.getEmail())
        .phone(doctor.getPhone())
        .crm(doctor.getCrm())
        .expertise(doctor.getExpertise())
        .addressDto(addressDto)
        .active(doctor.getActive())
        .build();
  }
}
