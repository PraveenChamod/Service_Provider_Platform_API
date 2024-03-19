package com.ServiceProviderPlatform.Service_Provider_Platform_API.repository;

import com.ServiceProviderPlatform.Service_Provider_Platform_API.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
