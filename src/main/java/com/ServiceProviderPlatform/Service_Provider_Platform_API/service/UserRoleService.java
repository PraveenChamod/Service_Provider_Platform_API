package com.ServiceProviderPlatform.Service_Provider_Platform_API.service;

import com.ServiceProviderPlatform.Service_Provider_Platform_API.enums.ApplicationRole;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.exception.CustomException;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.model.UserRole;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserRoleService {
    private final UserRoleRepository userRoleRepository;

    public Optional<UserRole> findByName(ApplicationRole name){
        try{
            return userRoleRepository.findByName(name);
        } catch (Exception e) {
            throw new CustomException("An error occurred while finding the trainer.", e);
        }
    }

}
