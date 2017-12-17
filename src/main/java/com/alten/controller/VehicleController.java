package com.alten.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alten.service.CustomerApi;
import com.alten.service.VehicleService;
import com.alten.dto.VehicleDetailDTO;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@EnableAutoConfiguration
public class VehicleController {
	

	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private CustomerApi customerApi;
	
	@RequestMapping(value="/addVehicles",method=RequestMethod.GET)
    public void addVehicles() {
    	vehicleService.pushData();
        
    }
	
	@RequestMapping(value="/getVehicles",method=RequestMethod.GET)
    public List<VehicleDetailDTO> getVehicles() {
    	return vehicleService.getAllVehicles();
        
    }
	
}