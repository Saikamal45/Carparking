package com.automatic.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ParkingSlot {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int slotNumber;

    private boolean booked;
    private String startTime;
    private String endTime;
    private String name;
    private String phoneNumber;

   

}
