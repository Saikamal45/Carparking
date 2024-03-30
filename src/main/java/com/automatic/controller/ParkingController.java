package com.automatic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.automatic.model.ParkingSlot;
import com.automatic.service.Parkingservice;

@RestController
@RequestMapping("/parking")
public class ParkingController {

	@Autowired
	private Parkingservice parkingservice;
	
	 @GetMapping("/slots")
	    public List<ParkingSlot> getAllParkingSlots() {
	        return parkingservice.getAllParkingSlots();
	    }

	    @PostMapping("/book")
	    public String bookSlot(@RequestParam int slotNumber,
	                           @RequestParam String startTime,
	                           @RequestParam String endTime,
	                           @RequestParam String name,
	                           @RequestParam String phoneNumber) {
	        boolean booked = parkingservice.bookSlot(slotNumber, startTime, endTime,name, phoneNumber);
	        if (booked) {
	            return "Slot booked successfully.";
	        } else {
	            return "Failed to book slot. Slot may be already booked or invalid slot number.";
	        }
	    }

	    @GetMapping("/vacant")
	    public int getVacantSlotsCount() {
	        return parkingservice.getVacantSlotsCount();
	    }

	    @GetMapping("/booked")
	    public int getBookedSlotsCount() {
	        return parkingservice.getBookedSlotsCount();
	    }
}
