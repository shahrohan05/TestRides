# TestRides
Hypothetical system to understand TDD with JUnit 5 and Mockito

**Business objects:**
- n number of rides and n number of riders
- Each ride has a limited capacity
- Each rider can only ride/schedule 1 ride at a time.

**Business logic/functions:**
- *checkRiderEligibility()*, check if the rider has not already scheduled a ride.
- *checkRideAvailability()*, check if ride capacity is not full.
- *scheduleRide()*, if the ride is available and rider is eligible, schedule the ride.
  
