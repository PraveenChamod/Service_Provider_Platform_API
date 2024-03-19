package com.ServiceProviderPlatform.Service_Provider_Platform_API.model;

import com.ServiceProviderPlatform.Service_Provider_Platform_API.enums.ApplicationRole;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ApplicationRole name;

    public UserRole(ApplicationRole name) {
        this.name = name;
    }
}
