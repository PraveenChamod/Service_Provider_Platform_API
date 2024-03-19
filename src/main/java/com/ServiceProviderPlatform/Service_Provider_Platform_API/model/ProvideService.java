package com.ServiceProviderPlatform.Service_Provider_Platform_API.model;

import com.ServiceProviderPlatform.Service_Provider_Platform_API.enums.ActiveStatus;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.enums.ServiceCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "provideService")
public class ProvideService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    private String serviceName;
    private String description;
    private ServiceCategory serviceCategory;
    private Integer noOfAllowedClients;
    private Double pricePerSession;
    private Integer sessionDuration;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private ActiveStatus status;
}
