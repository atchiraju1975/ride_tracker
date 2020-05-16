package com.pluralsight.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.pluralsight.repository.util.RideRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.pluralsight.model.Ride;

@Repository("rideRepository")
public class RideRepositoryImpl implements RideRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Ride createRide(Ride ride) {

		jdbcTemplate.update("insert into ride (name, duration) values (?,?)", ride.getName(), ride.getDuration());


		return null;
	}

	@Override
	public List<Ride> getRides() {

		List<Ride> rides = jdbcTemplate.query("select * from ride", new RideRowMapper());

		return rides;
	}
	
}
