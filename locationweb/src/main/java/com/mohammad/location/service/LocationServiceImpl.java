package com.mohammad.location.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mohammad.location.entities.Location;
import com.mohammad.location.repos.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {

	private LocationRepository repository;
	@Override
	public Location saveLocation(Location location) {
		
		return repository.save(location);
	}

	@Override
	public Location updateLocation(Location location) {
		
		return repository.save(location);
	}

	@Override
	public void deleteLocation(Location location) {
		repository.delete(location);
	}

	@Override
	public Location getLocationById(int id) {
		
		return repository.findOne(id);
	}

	@Override
	public List<Location> getAllLocation() {
		
		return repository.findAll();
	}

}
