package com.ServiceProviderPlatform.Service_Provider_Platform_API.service.Mapper;

import com.ServiceProviderPlatform.Service_Provider_Platform_API.dto.AddressDTO;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.model.Address;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class AddressDTOMapper implements Function<Address, AddressDTO> {

    @Override
    public AddressDTO apply(Address address){
        return new AddressDTO(
                address.getId(),
                address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getPostalCode(),
                address.getCountry()
        );
    }
}
