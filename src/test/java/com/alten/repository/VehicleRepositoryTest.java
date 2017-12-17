package com.alten.repository;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

import com.alten.dto.Vehicle;
import com.alten.repository.VehicleRepository;


@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class VehicleRepositoryTest {
	 	@Autowired
	    public TestEntityManager entityManager;

	    @Autowired
	    VehicleRepository vehRepos;

	    @Test
	    public void findByCustomerAddress() {
	        Vehicle vehicle = new Vehicle("Test vehicle ID",12,"Test123","Test Status");
//	        vehicle.setVehicleID("Test vehicle ID");
//	        vehRepos.save(vehicle);
	        entityManager.persist(vehicle);
	        entityManager.flush();

	        List<Vehicle> findByVehicleID = vehRepos.findByVehicleID(vehicle.getVehicleID());

	        assertThat(findByVehicleID).extracting(Vehicle::getVehicleID).containsOnly(vehicle.getVehicleID());
	    }

}