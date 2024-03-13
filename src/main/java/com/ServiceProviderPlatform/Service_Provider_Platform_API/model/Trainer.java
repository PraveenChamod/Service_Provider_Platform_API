package com.ServiceProviderPlatform.Service_Provider_Platform_API.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "trainer")
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String businessLocation;
    private String telephone;
    private String brandName;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "trainer")
    private List<ManageService> manageServices;

    public Trainer() {
    }

    public Trainer(long id, String businessLocation, String telephone, String brandName, User user) {
        this.id = id;
        this.businessLocation = businessLocation;
        this.telephone = telephone;
        this.brandName = brandName;
        this.user = user;
    }

    public Trainer(String businessLocation, String telephone, String brandName, User user) {
        this.businessLocation = businessLocation;
        this.telephone = telephone;
        this.brandName = brandName;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBusinessLocation() {
        return businessLocation;
    }

    public void setBusinessLocation(String businessLocation) {
        this.businessLocation = businessLocation;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
