package com.ServiceProviderPlatform.Service_Provider_Platform_API.model;

import com.ServiceProviderPlatform.Service_Provider_Platform_API.enums.ActiveStatus;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.enums.ExperienceLevel;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.enums.ExperienceType;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.enums.TrainingGoal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ExperienceLevel experienceLevel;
    private ExperienceType experienceType;
    private TrainingGoal trainingGoal;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id")
    private Member member;

    private ActiveStatus status;
}
