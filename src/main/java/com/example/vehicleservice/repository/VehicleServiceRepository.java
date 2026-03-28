package com.example.vehicleservice.repository;

import com.example.vehicleservice.model.VehicleService;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VehicleServiceRepository extends JpaRepository<VehicleService, Long> {

    List<VehicleService> findByVehicleNumber(String vehicleNumber);

    List<VehicleService> findByServiceType(String serviceType);
}