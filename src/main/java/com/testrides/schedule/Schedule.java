package com.testrides.schedule;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BooleanSupplier;

import com.testrides.ride.Ride;
import com.testrides.rider.Rider;

public class Schedule {

	private Map<Ride, Set<Rider>> schedule;

	private SchedulingHelper schedulingHelper;

	public Schedule() {
	}

	public Schedule(Map<Ride, Set<Rider>> schedule) {
		super();
		this.schedule = schedule;
	}

	public Schedule(Map<Ride, Set<Rider>> schedule, SchedulingHelper schedulingHelper) {
		super();
		this.schedule = schedule;
		this.setSchedulingHelper(schedulingHelper);
	}

	public Map<Ride, Set<Rider>> getSchedule() {
		return schedule;
	}

	public void setSchedule(Map<Ride, Set<Rider>> schedule) {
		this.schedule = schedule;
	}

	
	 public boolean scheduleRide(Rider mike, Ride availableRide) { 
		 return false; 
	 }
	 

	/*public boolean scheduleRide(Rider rider, Ride ride) {
		if (!schedule.containsKey(ride)) {
			schedule.put(ride, new HashSet<Rider>());
		}

		if (riderEligible(rider) && rideAvailable(ride)) {
			System.out.println(schedulingHelper.notifyRiders());
			return schedule.get(ride).add(rider);
		}

		return false;
	}*/

	private boolean rideAvailable(Ride ride) {
		// check if the ride capacity is full
		return (schedule.get(ride).size() < ride.getCapacity());
	}

	private boolean riderEligible(Rider rider) {
		// check if the rider has already scheduled a ride
		return !schedule.keySet().stream().anyMatch(ride -> schedule.get(ride).contains(rider));

	}

	public SchedulingHelper getSchedulingHelper() {
		return schedulingHelper;
	}

	public void setSchedulingHelper(SchedulingHelper schedulingHelper) {
		this.schedulingHelper = schedulingHelper;
	}

}
