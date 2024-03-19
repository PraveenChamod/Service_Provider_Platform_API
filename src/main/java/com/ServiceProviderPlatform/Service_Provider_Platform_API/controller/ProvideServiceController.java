package com.ServiceProviderPlatform.Service_Provider_Platform_API.controller;

import com.ServiceProviderPlatform.Service_Provider_Platform_API.dto.ProvideServiceDTO;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.dto.ProvideServiceFilterDTO;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.enums.ActiveStatus;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.model.ProvideService;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.model.Trainer;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.model.User;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.service.ProvideServiceService;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.service.TrainerService;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path ="/api/v1/service")
public class ProvideServiceController {
    private final TrainerService trainerService;
    private final UserService userService;
    private final ProvideServiceService provideServiceService;

    @PostMapping("/create-service/{id}")
    public ProvideServiceDTO createService(@Validated @RequestBody ProvideService provideService, @PathVariable(name = "id") Long id) {

        Optional<User> existingUserOptional = userService.findUserById(id);
        if (existingUserOptional.isPresent()){
            User existingUser = existingUserOptional.get();
            Trainer existingTrainer = existingUser.getMember().getTrainer();

            ProvideService provideServiceIn = ProvideService.builder()
                    .serviceName(provideService.getServiceName())
                    .description(provideService.getDescription())
                    .serviceCategory(provideService.getServiceCategory())
                    .noOfAllowedClients(provideService.getNoOfAllowedClients())
                    .pricePerSession(provideService.getPricePerSession())
                    .sessionDuration(provideService.getSessionDuration())
                    .createdDate(LocalDateTime.now())
                    .updatedDate(LocalDateTime.now())
                    .status(ActiveStatus.ACTIVE)
                    .trainer(existingTrainer)
                    .build();
            return provideServiceService.saveProvideService(provideServiceIn);
        } else {
            return null;
        }
    }

    @GetMapping("/filter-services")
    public List<ProvideServiceDTO> filterServices(@RequestBody ProvideServiceFilterDTO provideServiceFilterDTO){
        List<ProvideService> provideServices = provideServiceService.getAllProvideServices();
        if(provideServices != null){
            return provideServiceService.filterProvideServices(provideServiceFilterDTO);
        }else{
            return null;
        }
    }
}
