package com.ServiceProviderPlatform.Service_Provider_Platform_API.service.Mapper;

import com.ServiceProviderPlatform.Service_Provider_Platform_API.dto.TrainerDTO;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.model.Trainer;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class TrainerDTOMapper implements Function<Trainer, TrainerDTO> {

    @Override
    public TrainerDTO apply(Trainer trainer){
        return new TrainerDTO(
                trainer.getId(),
                trainer.getBusinessLocation(),
                trainer.getTelephone(),
                trainer.getBrandName(),
                trainer.getStatus()
        );
    }
}
