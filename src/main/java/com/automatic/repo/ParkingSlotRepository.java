package com.automatic.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automatic.model.ParkingSlot;



@Repository
public interface ParkingSlotRepository extends JpaRepository<ParkingSlot, Integer>{
	 int countAllByBookedFalse();

	    int countAllByBookedTrue();
}
