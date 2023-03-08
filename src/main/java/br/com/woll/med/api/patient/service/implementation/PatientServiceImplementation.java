package br.com.woll.med.api.patient.service.implementation;

import br.com.woll.med.api.address.model.Address;
import br.com.woll.med.api.patient.dto.EditPatientDto;
import br.com.woll.med.api.patient.dto.ListAllPatientsDto;
import br.com.woll.med.api.patient.dto.PatientDto;
import br.com.woll.med.api.patient.mapper.PatientMapper;
import br.com.woll.med.api.patient.model.Patient;
import br.com.woll.med.api.patient.repository.PatientRepository;
import br.com.woll.med.api.patient.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientServiceImplementation implements PatientService {
  private final PatientRepository repository;

  @Override
  public ResponseEntity createNewPatient(PatientDto patientDto, UriComponentsBuilder uriBuilder) {
    Patient patient = PatientMapper.toPatient(patientDto);
    repository.save(patient);

    URI uri = uriBuilder.path("/api/v1/patient/{id}").buildAndExpand(patient.getId()).toUri();

    return ResponseEntity.created(uri).body(PatientMapper.toPatientDto(patient));
  }

  @Override
  public Page<ListAllPatientsDto> findAll(Pageable pageable) {
    return repository
        .findAllByActiveTrue(pageable)
        .map(ListAllPatientsDto::new);
  }

  @Override
  public PatientDto updatePatient(EditPatientDto editPatientDto) {
    Patient patient = repository.getReferenceById(editPatientDto.getId());

    if(editPatientDto.getName() != null) patient.setName(editPatientDto.getName());
    if(editPatientDto.getPhone() != null) patient.setPhone(editPatientDto.getPhone());

    if(editPatientDto.getAddressDto() != null) {
      Address address = patient.getAddress();

      if (editPatientDto.getAddressDto().getStreet() != null) {
        address.setStreet(editPatientDto.getAddressDto().getStreet());
      }
      if (editPatientDto.getAddressDto().getNumber() != null) {
        address.setNumber(editPatientDto.getAddressDto().getNumber());
      }
      if (editPatientDto.getAddressDto().getNeighborhood() != null) {
        address.setNeighborhood(editPatientDto.getAddressDto().getNeighborhood());
      }
      if (editPatientDto.getAddressDto().getCity() != null) {
        address.setCity(editPatientDto.getAddressDto().getCity());
      }
      if (editPatientDto.getAddressDto().getUf() != null) {
        address.setUf(editPatientDto.getAddressDto().getUf());
      }
      if (editPatientDto.getAddressDto().getCep() != null) {
        address.setCep(editPatientDto.getAddressDto().getCep());
      }
      if (editPatientDto.getAddressDto().getComplement() != null) {
        address.setComplement(editPatientDto.getAddressDto().getComplement());
      }
    }

    return PatientMapper.toPatientDto(patient);
  }

  @Override
  public void deletePatient(UUID id) {
    Patient patient = repository.getReferenceById(id);
    patient.setActive(false);
  }
}
