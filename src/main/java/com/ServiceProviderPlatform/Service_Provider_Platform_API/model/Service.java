package com.ServiceProviderPlatform.Service_Provider_Platform_API.model;

import com.ServiceProviderPlatform.Service_Provider_Platform_API.enums.ServiceCategory;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String serviceName;
    private String description;
    private ServiceCategory serviceCategory;
    private Integer noOfAllowedClients;
    private Double pricePerSession;
    private Integer sessionDuration;
    @OneToMany(mappedBy = "service")
    private List<ManageService> manageServices;

    public Service() {
    }

    public Service(long id, String serviceName, String description, ServiceCategory serviceCategory, Integer noOfAllowedClients, Double pricePerSession, Integer sessionDuration) {
        this.id = id;
        this.serviceName = serviceName;
        this.description = description;
        this.serviceCategory = serviceCategory;
        this.noOfAllowedClients = noOfAllowedClients;
        this.pricePerSession = pricePerSession;
        this.sessionDuration = sessionDuration;
    }

    public Service(String serviceName, String description, ServiceCategory serviceCategory, Integer noOfAllowedClients, Double pricePerSession, Integer sessionDuration) {
        this.serviceName = serviceName;
        this.description = description;
        this.serviceCategory = serviceCategory;
        this.noOfAllowedClients = noOfAllowedClients;
        this.pricePerSession = pricePerSession;
        this.sessionDuration = sessionDuration;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ServiceCategory getServiceCategory() {
        return serviceCategory;
    }

    public void setServiceCategory(ServiceCategory serviceCategory) {
        this.serviceCategory = serviceCategory;
    }

    public Integer getNoOfAllowedClients() {
        return noOfAllowedClients;
    }

    public void setNoOfAllowedClients(Integer noOfAllowedClients) {
        this.noOfAllowedClients = noOfAllowedClients;
    }

    public Double getPricePerSession() {
        return pricePerSession;
    }

    public void setPricePerSession(Double pricePerSession) {
        this.pricePerSession = pricePerSession;
    }

    public Integer getSessionDuration() {
        return sessionDuration;
    }

    public void setSessionDuration(Integer sessionDuration) {
        this.sessionDuration = sessionDuration;
    }
}
