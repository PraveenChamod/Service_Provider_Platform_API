package com.ServiceProviderPlatform.Service_Provider_Platform_API.service.Mapper;

import com.ServiceProviderPlatform.Service_Provider_Platform_API.dto.ProvideServiceDTO;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.model.ProvideService;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ProvideServiceDTOMapper implements Function<ProvideService, ProvideServiceDTO> {

    @Override
    public ProvideServiceDTO apply(ProvideService provideService){
        return new ProvideServiceDTO(
                provideService.getId(),
                provideService.getServiceName(),
                provideService.getDescription(),
                provideService.getServiceCategory(),
                provideService.getNoOfAllowedClients(),
                provideService.getPricePerSession(),
                provideService.getSessionDuration(),
                provideService.getCreatedDate(),
                provideService.getUpdatedDate(),
                provideService.getStatus()
        );
    }
}