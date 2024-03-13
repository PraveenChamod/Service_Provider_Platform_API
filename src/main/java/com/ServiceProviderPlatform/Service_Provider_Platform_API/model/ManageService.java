package com.ServiceProviderPlatform.Service_Provider_Platform_API.model;

import com.ServiceProviderPlatform.Service_Provider_Platform_API.enums.ManageServiceDescription;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "manageService")
public class ManageService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;
    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;
    private ManageServiceDescription description;
    private LocalDateTime date;
    private LocalDateTime time;

    public ManageService() {
    }

    public ManageService(long id, Trainer trainer, Service service, ManageServiceDescription description, LocalDateTime date, LocalDateTime time) {
        this.id = id;
        this.trainer = trainer;
        this.service = service;
        this.description = description;
        this.date = date;
        this.time = time;
    }

    public ManageService(Trainer trainer, Service service, ManageServiceDescription description, LocalDateTime date, LocalDateTime time) {
        this.trainer = trainer;
        this.service = service;
        this.description = description;
        this.date = date;
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public ManageServiceDescription getDescription() {
        return description;
    }

    public void setDescription(ManageServiceDescription description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
