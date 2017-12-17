package com.alten.controller;

import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static java.util.Collections.singletonList;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.mockito.BDDMockito.given;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;

import com.alten.controller.VehicleController;
import com.alten.dto.VehicleDetailDTO;

@RunWith(SpringRunner.class)
@WebMvcTest(VehicleController.class)
public class VehicleControllerTest {
	
	 @Autowired
	   private MockMvc mvc;
	 
	 @MockBean
	 	private VehicleController vehicleController;

	@Test
    public void addVehicles() throws Exception{
    	
    	RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/addVehicles").accept(
				MediaType.APPLICATION_JSON);
    	mvc.perform(requestBuilder).andExpect(status().isOk());
        
    }
	
	@Test
    public void getVehiclesTest() throws Exception {
		VehicleDetailDTO vehicle = new VehicleDetailDTO();
		vehicle.setVehicleID("Test Vehicle ID");
    	List<VehicleDetailDTO> VehicleTestList= singletonList(vehicle);
    	given(vehicleController.getVehicles()).willReturn(VehicleTestList);
    	RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/getVehicles").accept(
				MediaType.APPLICATION_JSON);
    	mvc.perform(requestBuilder).andExpect(status().isOk())
    	.andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].vehicleID", is(vehicle.getVehicleID())));
        
    }
}