package com.automatic.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.automatic.model.ParkingSlot;
import com.automatic.repo.ParkingSlotRepository;

import jakarta.annotation.PostConstruct;



@Service
public class Parkingservice {

	@Autowired
	private ParkingSlotRepository parkingSlotRepository;
	
	@PostConstruct
    public void initParkingSlots() {
        List<ParkingSlot> existingSlots = parkingSlotRepository.findAll();
        if (existingSlots.size() < 20) {
            for (int i = 1; i <= 20; i++) {
                ParkingSlot slot = new ParkingSlot();
                slot.setSlotNumber(i);
                slot.setBooked(false);
                parkingSlotRepository.save(slot);
            }
        }
    }

    public List<ParkingSlot> getAllParkingSlots() {
        return parkingSlotRepository.findAll();
    }

    public boolean bookSlot(int slotNumber, String startTime, String endTime,String name, String phoneNumber) {
        ParkingSlot slot = parkingSlotRepository.findById(slotNumber)
                                                .orElseThrow(() -> new IllegalArgumentException("Invalid slot number"));
        if (!slot.isBooked()) {
            slot.setBooked(true);
            slot.setStartTime(startTime);
            slot.setEndTime(endTime);
            slot.setName(name);
            slot.setPhoneNumber(phoneNumber);
            parkingSlotRepository.save(slot);
            return true; // Booking successful
        } else {
            return false; // Slot is already booked
        }
    }

    public int getVacantSlotsCount() {
        return parkingSlotRepository.countAllByBookedFalse();
    }

    public int getBookedSlotsCount() {
        return parkingSlotRepository.countAllByBookedTrue();
    }
}
	
	
