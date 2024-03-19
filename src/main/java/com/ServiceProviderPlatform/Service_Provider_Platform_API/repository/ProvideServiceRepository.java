package com.ServiceProviderPlatform.Service_Provider_Platform_API.repository;

import com.ServiceProviderPlatform.Service_Provider_Platform_API.enums.ServiceCategory;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.model.ProvideService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvideServiceRepository extends JpaRepository<ProvideService, Long> {
    List<ProvideService> findByPricePerSessionBetween(Double lowPrice, Double highPrice);
    List<ProvideService> findByServiceCategory(ServiceCategory serviceCategory);
}
