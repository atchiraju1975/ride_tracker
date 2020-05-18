package com.pluralsight.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pluralsight.model.Ride;
import com.pluralsight.repository.RideRepository;

@Service("rideService")
public class RideServiceImpl implements RideService {

	@Autowired
	private RideRepository rideRepository;

	@Override
	public Ride createRide(Ride ride) {
		return rideRepository.createRide(ride);
	}

	@Override
	public List<Ride> getRides() {
		return rideRepository.getRides();
	}

	@Override
	public Ride getRide(Integer id) {
		return rideRepository.getRide(id);
	}

	@Override
	public Ride updateRide(Ride ride) {
		return rideRepository.updateRide(ride);
	}

	@Override
	public void batch() {
		List<Ride> rides = rideRepository.getRides();
		List<Object[]> pairs = new ArrayList<>();
		Integer sequence = 0;

		Calendar c = Calendar.getInstance();


		for (Ride ride : rides){


			Object[] tmp = { c.getTime(), ride.getId()};

			pairs.add(tmp);
			sequence = sequence + 1;

			c.add(Calendar.DAY_OF_MONTH,sequence);

		}

		rideRepository.updateRides(pairs);

	}
}
