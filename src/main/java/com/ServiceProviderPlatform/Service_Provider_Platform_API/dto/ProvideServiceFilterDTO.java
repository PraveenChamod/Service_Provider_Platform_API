package com.ServiceProviderPlatform.Service_Provider_Platform_API.dto;

import com.ServiceProviderPlatform.Service_Provider_Platform_API.enums.ServiceCategory;

import java.util.Optional;

public record ProvideServiceFilterDTO(
        Double lowPricePerSession,
        Double highPricePerSession,
        ServiceCategory serviceCategory
) {
}
