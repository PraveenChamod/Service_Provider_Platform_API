package com.ServiceProviderPlatform.Service_Provider_Platform_API.service;

import com.ServiceProviderPlatform.Service_Provider_Platform_API.dto.ProvideServiceDTO;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.dto.ProvideServiceFilterDTO;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.enums.ServiceCategory;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.exception.CustomException;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.model.ProvideService;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.repository.ProvideServiceRepository;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.service.Mapper.ProvideServiceDTOMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProvideServiceService {
    private final ProvideServiceRepository provideServiceRepository;
    private final ProvideServiceDTOMapper provideServiceDTOMapper;

    @Transactional
    public ProvideServiceDTO saveProvideService(ProvideService provideService) {
        try{
            ProvideService savedProvideService = provideServiceRepository.save(provideService);
            return provideServiceDTOMapper.apply(savedProvideService);
        } catch (Exception e) {
            throw new CustomException("An error occurred while saving service.", e);
        }
    }

    public List<ProvideService> getAllProvideServices() {
        try{
            return provideServiceRepository.findAll();
        } catch (Exception e) {
            throw new CustomException("An error occurred while fetching the service.", e);
        }
    }

    public List<ProvideServiceDTO> filterProvideServices(ProvideServiceFilterDTO provideServiceFilterDTO) {
        try{
            List<ProvideServiceDTO> filteredServices = new ArrayList<>();

            Double lowPrice = provideServiceFilterDTO.lowPricePerSession();
            Double highPrice = provideServiceFilterDTO.highPricePerSession();
            ServiceCategory category = provideServiceFilterDTO.serviceCategory();

            if (lowPrice != null || highPrice != null || category != null) {
                List<ProvideService> filteredServicesByRange = provideServiceRepository.findByPricePerSessionBetween(
                        lowPrice != null ? lowPrice : 0.0,
                        highPrice != null ? highPrice : Double.MAX_VALUE
                );
                for (ProvideService provideService : filteredServicesByRange) {
                    if (category == null || provideService.getServiceCategory() == category) {
                        filteredServices.add(provideServiceDTOMapper.apply(provideService));
                    }
                }
            }
            return filteredServices;
        } catch (Exception e) {
            throw new CustomException("An error occurred while filtering the services.", e);
        }
    }
}
