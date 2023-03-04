package br.com.woll.med.api.doctor.service.implementation;

import br.com.woll.med.api.address.model.Address;
import br.com.woll.med.api.doctor.dto.DoctorDto;
import br.com.woll.med.api.doctor.dto.EditDoctorDto;
import br.com.woll.med.api.doctor.dto.ListAllDoctorsDto;
import br.com.woll.med.api.doctor.mapper.DoctorMapper;
import br.com.woll.med.api.doctor.model.Doctor;
import br.com.woll.med.api.doctor.repository.DoctorRepository;
import br.com.woll.med.api.doctor.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorServiceImplementation implements DoctorService {
  private final DoctorRepository repository;

  @Override
  public void createNewDoctor(DoctorDto doctorDto) {
    Doctor doctor = DoctorMapper.toDoctor(doctorDto);
    repository.save(doctor);
  }

  @Override
  public List<ListAllDoctorsDto> findAll() {
    return repository
        .findAll()
        .stream()
        .map(doctor -> new ListAllDoctorsDto(doctor))
        .collect(Collectors.toList());
  }

  @Override
  public Page<ListAllDoctorsDto> findAllOrderly(Pageable pageable) {
    return repository
        .findAllByActiveTrue(pageable)
        .map(ListAllDoctorsDto::new);
  }

  @Override
  public void updateDoctor(EditDoctorDto editDoctorDto) {
    Doctor doctor = repository.getReferenceById(editDoctorDto.getId());

    if(editDoctorDto.getName() != null) doctor.setName(editDoctorDto.getName());
    if(editDoctorDto.getPhone() != null) doctor.setPhone(editDoctorDto.getPhone());

    if(editDoctorDto.getAddressDto() != null) {
      Address address = doctor.getAddress();

      if (editDoctorDto.getAddressDto().getStreet() != null) {
        address.setStreet(editDoctorDto.getAddressDto().getStreet());
      }
      if (editDoctorDto.getAddressDto().getNumber() != null) {
        address.setNumber(editDoctorDto.getAddressDto().getNumber());
      }
      if (editDoctorDto.getAddressDto().getNeighborhood() != null) {
        address.setNeighborhood(editDoctorDto.getAddressDto().getNeighborhood());
      }
      if (editDoctorDto.getAddressDto().getCity() != null) {
        address.setCity(editDoctorDto.getAddressDto().getCity());
      }
      if (editDoctorDto.getAddressDto().getUf() != null) {
        address.setUf(editDoctorDto.getAddressDto().getUf());
      }
      if (editDoctorDto.getAddressDto().getCep() != null) {
        address.setCep(editDoctorDto.getAddressDto().getCep());
      }
      if (editDoctorDto.getAddressDto().getComplement() != null) {
        address.setComplement(editDoctorDto.getAddressDto().getComplement());
      }
    }
  }

  @Override
  public void deleteDoctor(UUID id) {
    Doctor doctor = repository.getReferenceById(id);
    doctor.setActive(false);
  }
}
