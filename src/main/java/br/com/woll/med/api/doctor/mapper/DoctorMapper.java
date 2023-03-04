package br.com.woll.med.api.doctor.mapper;

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
}
