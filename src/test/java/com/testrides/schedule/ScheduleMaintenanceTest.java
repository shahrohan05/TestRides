package com.testrides.schedule;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.testrides.ride.Ride;
import com.testrides.rider.Rider;

@DisplayName("Test ride scheduling functionality")
@ExtendWith(MockitoExtension.class)
public class ScheduleMaintenanceTest {

	@Mock
	ScheduleHelper scheduleHelper;

	@InjectMocks
	ScheduleMaintenance scheduleMaintenance; // class under test

	Ride availableRide;
	Ride anotherRide;
	Ride fullRide;
	
	Rider mike; // eligible rider
	Rider sam; // ineligible rider
	
	@BeforeAll
	public static void beforeAll() {
		System.out.println("One time setup.");
	}
	
	@AfterAll
	public static void afterAll() {
		System.out.println("Cleanup, if any.");
	}

	@BeforeEach
	public void setup() {
		
		availableRide = new Ride(1, "Joyride 1", "Car", 5);
		anotherRide = new Ride(2, "Joyride 2","Bus",50);
		fullRide = new Ride(3, "Joyride 3", "Imaginary", 0);
		
		mike = new Rider(1, "mike");
		sam = new Rider(2, "sam");
		
		Map<Ride, Set<Rider>> scheduleData = new HashMap<>();
		
		Set<Rider> riders = new HashSet<>();
		riders.add(sam);
		
		scheduleData.put(anotherRide, riders);
		scheduleData.put(availableRide, new HashSet<Rider>());
		
		scheduleMaintenance.setSchedule(scheduleData);
		

		//Mockito.when(scheduleHelper.notifyRiders()).thenReturn("Users were notified!"); // unnecessary stubbing sample

	}

	@DisplayName("Given an available ride")
	@Nested
	class AvailableRide {

		@DisplayName("When an eligible rider tries to schedule a ride")
		@Nested
		class EligibleRider {

			@DisplayName("Then the ride should be scheduled")
			@Test
			public void testEligibleScheduling() {
				Mockito.when(scheduleHelper.notifyRiders()).thenReturn("[STUBBED] Users were notified!");
				 
				assertTrue(scheduleMaintenance.scheduleRide(mike, availableRide));
				System.out.println(scheduleMaintenance.getSchedule());
				
				Mockito.verify(scheduleHelper, Mockito.times(1)).notifyRiders();
			}
		}
		
		@DisplayName("When an ineligible rider tries to schedule a ride")
		@Nested
		class IneligibleRider {
			
			@DisplayName("Then the ride should not be scheduled")
			@Test
			public void testIneligibleScheduling() {
				assertFalse(scheduleMaintenance.scheduleRide(sam, availableRide));
				
			}
		}
		
	}
	
	@DisplayName("Given a full ride")
	@Nested
	class FullRide {
		
		@DisplayName("When an eligible rider tries to schedule the ride")
		@Nested
		class EligibleRider {
			
			@DisplayName("Then the ride should not be scheduled")
			@Test
			public void testEligibleScheduling() {
				assertFalse(scheduleMaintenance.scheduleRide(mike, fullRide));
				System.out.println(scheduleMaintenance.getSchedule());
				Mockito.verify(scheduleHelper, Mockito.times(0)).notifyRiders();
			}
		}
	}

}
