package com.ServiceProviderPlatform.Service_Provider_Platform_API.model;

import com.ServiceProviderPlatform.Service_Provider_Platform_API.enums.ExperienceLevel;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.enums.ExperienceType;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.enums.TrainingGoal;
import jakarta.persistence.*;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private ExperienceLevel experienceLevel;
    private ExperienceType experienceType;
    private TrainingGoal trainingGoal;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Client() {
    }

    public Client(long id, ExperienceLevel experienceLevel, ExperienceType experienceType, TrainingGoal trainingGoal, User user) {
        this.id = id;
        this.experienceLevel = experienceLevel;
        this.experienceType = experienceType;
        this.trainingGoal = trainingGoal;
        this.user = user;
    }

    public Client(ExperienceLevel experienceLevel, ExperienceType experienceType, TrainingGoal trainingGoal, User user) {
        this.experienceLevel = experienceLevel;
        this.experienceType = experienceType;
        this.trainingGoal = trainingGoal;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ExperienceLevel getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(ExperienceLevel experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public ExperienceType getExperienceType() {
        return experienceType;
    }

    public void setExperienceType(ExperienceType experienceType) {
        this.experienceType = experienceType;
    }

    public TrainingGoal getTrainingGoal() {
        return trainingGoal;
    }

    public void setTrainingGoal(TrainingGoal trainingGoal) {
        this.trainingGoal = trainingGoal;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
