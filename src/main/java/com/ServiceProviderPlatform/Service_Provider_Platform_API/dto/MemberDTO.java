package com.ServiceProviderPlatform.Service_Provider_Platform_API.dto;

import com.ServiceProviderPlatform.Service_Provider_Platform_API.enums.Gender;

import java.time.LocalDateTime;
import java.util.List;

public record MemberDTO(
        Long id,
        String firstName,
        String lastName,
        List<AddressDTO>addresses,
        LocalDateTime birthday,
        Gender gender,
        String language,
        ClientDTO client
) {
}
