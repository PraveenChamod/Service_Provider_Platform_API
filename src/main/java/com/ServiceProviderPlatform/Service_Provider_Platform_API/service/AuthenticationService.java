package com.ServiceProviderPlatform.Service_Provider_Platform_API.service;

import com.ServiceProviderPlatform.Service_Provider_Platform_API.controller.auth.AuthenticationRequest;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.controller.auth.AuthenticationResponse;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.controller.auth.RegisterRequest;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.enums.ActiveStatus;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.enums.ApplicationRole;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.exception.CustomException;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.model.User;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.model.UserRole;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Permission;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final UserRoleService userRoleService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        try{
            Optional<UserRole> optionalRole = userRoleService.findByName(ApplicationRole.CLIENT);
            if (optionalRole.isPresent()){
                UserRole existingRole = optionalRole.get();
                List<UserRole> adminUserRole = List.of(existingRole);
                var user = User.builder()
                        .email(request.getEmail())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .status(ActiveStatus.ACTIVE)
                        .userRoles(adminUserRole)
                        .build();
                userRepository.save(user);
                var jwtToken = jwtService.generateToken(user);
                return AuthenticationResponse.builder()
                        .token(jwtToken)
                        .build();
            }
            return null;
        } catch (Exception e) {
            throw new CustomException("An error occurred while register the user.", e);
        }
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
            Optional<User> optionalUser = userRepository.findByEmail(request.getEmail());

            if(optionalUser.isPresent()){
                User user = optionalUser.get();
                var jwtToken = jwtService.generateToken(user);
                return AuthenticationResponse.builder()
                        .token(jwtToken)
                        .build();
            }
            return null;
        } catch (Exception e) {
            throw new CustomException("An error occurred while authenticate the user.", e);
        }
    }
}
