package com.alten.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alten.dto.CustomerDTO;

@FeignClient("CUSTOMERDETAILS")
public interface CustomerApi{
	@RequestMapping(method=RequestMethod.GET,value="/getCustomerDetails/{custID}")
	ResponseEntity<CustomerDTO> getCustomerDetails(@PathVariable("custID") int custID);
}