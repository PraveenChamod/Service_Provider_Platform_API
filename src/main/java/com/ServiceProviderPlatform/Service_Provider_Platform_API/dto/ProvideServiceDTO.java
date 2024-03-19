package com.ServiceProviderPlatform.Service_Provider_Platform_API.dto;

import com.ServiceProviderPlatform.Service_Provider_Platform_API.enums.ActiveStatus;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.enums.ServiceCategory;

import java.time.LocalDateTime;

public record ProvideServiceDTO(
        Long id,
        String serviceName,
        String description,
        ServiceCategory serviceCategory,
        Integer noOfAllowedClients,
        Double pricePerSession,
        Integer sessionDuration,
        LocalDateTime createdDate,
        LocalDateTime updatedDate,
        ActiveStatus status
) {
}
