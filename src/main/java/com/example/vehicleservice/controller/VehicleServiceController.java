package com.example.vehicleservice.controller;

import com.example.vehicleservice.model.VehicleService;
import com.example.vehicleservice.service.VehicleServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
@CrossOrigin
public class VehicleServiceController {

    @Autowired
    private VehicleServiceService service;

    @PostMapping
    public VehicleService addService(@RequestBody VehicleService vehicleService) {
        return service.addService(vehicleService);
    }

    @GetMapping
    public List<VehicleService> getAllServices() {
        return service.getAllServices();
    }

    @GetMapping("/{id}")
    public VehicleService getServiceById(@PathVariable Long id) {
        return service.getServiceById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteService(@PathVariable Long id) {
        service.deleteService(id);
        return "Service deleted successfully";
    }

    @GetMapping("/search/{vehicleNumber}")
    public List<VehicleService> searchByVehicle(@PathVariable String vehicleNumber) {
        return service.searchByVehicleNumber(vehicleNumber);
    }

    @GetMapping("/filter/{serviceType}")
    public List<VehicleService> filterByType(@PathVariable String serviceType) {
        return service.filterByServiceType(serviceType);
    }
}