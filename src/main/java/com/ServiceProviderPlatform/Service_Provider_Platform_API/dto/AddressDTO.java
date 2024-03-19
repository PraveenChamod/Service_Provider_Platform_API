package com.ServiceProviderPlatform.Service_Provider_Platform_API.dto;

public record AddressDTO(
        Long id,
        String street,
        String city,
        String state,
        String postalCode,
        String country
) {
}
