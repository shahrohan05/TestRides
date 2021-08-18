package com.testrides.schedule;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Set;

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

@DisplayName("Test Ride Scheduling functionality")
@ExtendWith(MockitoExtension.class)
public class ScheduleTest {

	@Mock
	SchedulingHelper schedulingHelper;

	@InjectMocks
	Schedule schedule;

	Ride availableRide;
	Rider mike;

	@BeforeEach
	public void setup() {
		schedule.setSchedule(new HashMap<Ride, Set<Rider>>());
		availableRide = new Ride(1, "Joyride 1", "Car", 5);
		mike = new Rider(1, "mike");

		Mockito.when(schedulingHelper.notifyRiders()).thenReturn("Users were notified!");

	}

	@DisplayName("Given an available ride")
	@Nested
	class AvailableRide {

		@DisplayName("When an eligible rider tries to schedule a ride")
		@Nested
		class EligibleRider {

			@DisplayName("Then the ride should be scheduled")
			@Test
			public void testAvailableScheduling() {
				assertTrue(schedule.scheduleRide(mike, availableRide));
				System.out.println(schedule.getSchedule());
				Mockito.verify(schedulingHelper, Mockito.times(1)).notifyRiders();
			}
		}
	}

}
