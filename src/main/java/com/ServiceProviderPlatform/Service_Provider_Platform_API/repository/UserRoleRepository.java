package com.ServiceProviderPlatform.Service_Provider_Platform_API.repository;

import com.ServiceProviderPlatform.Service_Provider_Platform_API.enums.ApplicationRole;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    Optional<UserRole> findByName(ApplicationRole name);

}
