package com.ServiceProviderPlatform.Service_Provider_Platform_API.config;

import com.ServiceProviderPlatform.Service_Provider_Platform_API.enums.ActiveStatus;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.enums.ApplicationRole;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.model.User;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.model.UserRole;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.repository.UserRepository;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.lang.CharSequence;

@Configuration
public class InitialConfig {

    @Value("${admin.user.password}")
    private String adminPassword;

    @Bean
    CommandLineRunner addRolesToDb(UserRoleRepository userRoleRepository) {
        Optional<UserRole> optionalAdminRole = userRoleRepository.findByName(ApplicationRole.ADMIN);
        Optional<UserRole> optionalTrainerRole = userRoleRepository.findByName(ApplicationRole.TRAINER);
        Optional<UserRole> optionalClientRole = userRoleRepository.findByName(ApplicationRole.CLIENT);

        return args -> {
            if(optionalAdminRole.isEmpty() && optionalTrainerRole.isEmpty() && optionalClientRole.isEmpty()){
                List<UserRole> userRoles = Arrays.asList(
                        new UserRole(ApplicationRole.ADMIN),
                        new UserRole(ApplicationRole.TRAINER),
                        new UserRole(ApplicationRole.CLIENT)
                );
                userRoleRepository.saveAll(userRoles);
            }
        };
    }

    @Bean
    CommandLineRunner addAdminUserToDb(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder){
        return args -> {
            Optional<User> optionalUser = userRepository.findByEmail("admin@gmail.com");
            if(optionalUser.isEmpty()){
                CharSequence adminPasswordCharSequence = adminPassword;
                Optional<UserRole> optionalRole = userRoleRepository.findByName(ApplicationRole.ADMIN);
                if (optionalRole.isPresent()){
                    UserRole existingRole = optionalRole.get();
                    List<UserRole> adminUserRole = List.of(existingRole);
                    User adminUser = new User(
                            "admin@gmail.com",
                            ActiveStatus.ACTIVE,
                            passwordEncoder.encode(adminPasswordCharSequence),
                            adminUserRole
                    );
                    userRepository.save(adminUser);
                }
            }
        };
    }

}