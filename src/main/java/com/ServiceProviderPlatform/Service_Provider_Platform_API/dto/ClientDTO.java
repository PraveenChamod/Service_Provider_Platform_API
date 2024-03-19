package com.ServiceProviderPlatform.Service_Provider_Platform_API.dto;

import com.ServiceProviderPlatform.Service_Provider_Platform_API.enums.ActiveStatus;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.enums.ExperienceLevel;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.enums.ExperienceType;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.enums.TrainingGoal;

public record ClientDTO(
        Long id,
        ExperienceLevel experienceLevel,
        ExperienceType experienceType,
        TrainingGoal trainingGoal,
        ActiveStatus status
) {
}
