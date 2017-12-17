package com.alten.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Scheduled;

import com.alten.dto.CustomerDTO;
import com.alten.dto.Vehicle;
import com.alten.dto.VehicleDetailDTO;
import com.alten.repository.VehicleRepository;
import com.alten.service.CustomerApi;

@Service
public class VehicleService{
	
	@Autowired
	private VehicleRepository vehRepo;
	
	@Autowired
	private CustomerApi customerApi;
	
	public static List<VehicleDetailDTO> vehicleList = new ArrayList<VehicleDetailDTO>();
	
	@EventListener(ApplicationReadyEvent.class)
	public void init() {
		pushData();
	}
	Random random = new Random();
	public void pushData() {
		
		vehRepo.save(new Vehicle("YS2R4X20005399401",81,"ABC123","Active"));
		vehRepo.save(new Vehicle("YS2R4X20005388011",82,"JKL012","Active"));
		vehRepo.save(new Vehicle("YS2R4X20005387765",83,"PQR678","Active"));
		vehRepo.save(new Vehicle("VLUR4X20009093588",81,"DEF456","Active"));
		vehRepo.save(new Vehicle("YS2R4X20005387949",82,"MNO345","Active"));
		vehRepo.save(new Vehicle("YS2R4X20005387055",83,"STU901","Active"));
		vehRepo.save(new Vehicle("VLUR4X20009048066",81,"GHI789","Active"));
	}
	
	public List<VehicleDetailDTO> getAllVehicles(){
		List<VehicleDetailDTO> vehicleDetailList= new ArrayList<VehicleDetailDTO>();
		for(Vehicle vehObj:vehRepo.findAll()) {
			
			VehicleDetailDTO vehicleDetail=new VehicleDetailDTO();
			vehicleDetail.setVehicleID(vehObj.getVehicleID());
			ResponseEntity<CustomerDTO> custDTO=customerApi.getCustomerDetails(vehObj.getCustomerID());
			if (null != custDTO) {
				CustomerDTO customerDTO = new CustomerDTO();
				customerDTO=custDTO.getBody();
				vehicleDetail.setCustomerName(customerDTO.getCustomerName());
				vehicleDetail.setCustomerAddress(customerDTO.getCustomerAddress());
				System.out.println("not null");
			}
			else
				System.out.println("its null");
			vehicleDetail.setReg_nr(vehObj.getReg_nr());
			vehicleDetail.setVehicle_status(vehObj.getVehicleStatus());
			vehicleDetailList.add(vehicleDetail);
		}
		System.out.println("Vehicle List get Vehicles  " + vehicleDetailList.size());
		return vehicleDetailList;
		
	}
	@Scheduled(fixedRate=60000)
	public void getUpdatedData() {
		
		final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		for(Vehicle vehObj:vehRepo.findAll()) {
			if(random.nextBoolean())
				vehObj.setVehicleStatus("Active");
			else
				vehObj.setVehicleStatus("Disconnected");
			vehRepo.save(vehObj);
			System.out.println("updated Details  " + vehObj.getCustomerID() + " --  " + vehObj.getVehicleStatus());
			System.out.println("The time is now "+ dateFormat.format(new Date()));
		}
	}
}