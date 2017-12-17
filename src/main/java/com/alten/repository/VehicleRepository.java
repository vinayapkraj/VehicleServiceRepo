package com.alten.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alten.dto.Vehicle;
@Repository
public interface VehicleRepository extends CrudRepository<Vehicle,String>{
	public List<Vehicle> findByVehicleID(String VehicleID);
}