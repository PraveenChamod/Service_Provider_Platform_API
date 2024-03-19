package com.ServiceProviderPlatform.Service_Provider_Platform_API.service;

import com.ServiceProviderPlatform.Service_Provider_Platform_API.exception.CustomException;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.model.User;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> findUserById(Long id){
        try{
            return userRepository.findById(id);
        } catch (Exception e) {
            throw new CustomException("An error occurred while finding the user.", e);
        }
    }

    public void updateUser(User user){
        try{
            userRepository.save(user);
        } catch (Exception e) {
            throw new CustomException("An error occurred while updating the user.", e);
        }
    }
}
