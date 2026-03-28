package com.example.vehicleservice.service;

import com.example.vehicleservice.model.VehicleService;
import com.example.vehicleservice.repository.VehicleServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.vehicleservice.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class VehicleServiceService {

    @Autowired
    private VehicleServiceRepository repository;

    public VehicleService addService(VehicleService service) {
        return repository.save(service);
    }

    public List<VehicleService> getAllServices() {
        return repository.findAll();
    }

    public VehicleService getServiceById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Service not found with ID: " + id));
    }

    public void deleteService(Long id) {
        repository.deleteById(id);
    }

    public List<VehicleService> searchByVehicleNumber(String vehicleNumber) {
        return repository.findByVehicleNumber(vehicleNumber);
    }

    public List<VehicleService> filterByServiceType(String serviceType) {
        return repository.findByServiceType(serviceType);
    }
}