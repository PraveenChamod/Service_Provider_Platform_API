package com.ServiceProviderPlatform.Service_Provider_Platform_API.dto;

import com.ServiceProviderPlatform.Service_Provider_Platform_API.enums.ActiveStatus;

public record TrainerDTO(
        Long id,
        String businessLocation,
        String telephone,
        String brandName,
        ActiveStatus status
) {
}
