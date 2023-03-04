package br.com.woll.med.api.address.mapper;

import br.com.woll.med.api.address.dto.AddressDto;
import br.com.woll.med.api.address.model.Address;

public class AddressMapper {
  public static Address toAddress(AddressDto addressDto) {
    return Address
        .builder()
        .street(addressDto.getStreet())
        .number(addressDto.getNumber())
        .neighborhood(addressDto.getNeighborhood())
        .cep(addressDto.getCep())
        .city(addressDto.getCity())
        .uf(addressDto.getUf())
        .complement(addressDto.getComplement())
        .build();
  }

//  public static AddressDto toAddressDto(Address address) {}
}
