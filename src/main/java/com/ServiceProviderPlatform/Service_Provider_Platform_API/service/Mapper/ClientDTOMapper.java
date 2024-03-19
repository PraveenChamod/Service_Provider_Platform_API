package com.ServiceProviderPlatform.Service_Provider_Platform_API.service.Mapper;

import com.ServiceProviderPlatform.Service_Provider_Platform_API.dto.ClientDTO;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.model.Client;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ClientDTOMapper implements Function<Client, ClientDTO> {

    @Override
    public ClientDTO apply(Client client){
        return new ClientDTO(
                client.getId(),
                client.getExperienceLevel(),
                client.getExperienceType(),
                client.getTrainingGoal(),
                client.getStatus()
        );
    }
}