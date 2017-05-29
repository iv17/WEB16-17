package BSEP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import BSEP.beans.Location;
import BSEP.repository.LocationRepository;

@Service
public class LocationService {

	@Autowired
	LocationRepository locationRepository;
	
	
	public Location findById(int id) {
		return locationRepository.findById(id);
	}
	
	public List<Location> findAll() {
		return locationRepository.findAll();
	}
	
	public Page<Location> findAll(Pageable page) {
		return locationRepository.findAll(page);
	}
	
	public Location save(Location location) {
		return locationRepository.save(location);
	}
	
	public Location saveAndFlush(Location location) {
		return locationRepository.saveAndFlush(location);
	}
	
	public void removeById(int id) {
		locationRepository.delete(id);
	}
	
	public void remove(Location location) {
		locationRepository.delete(location);
	}
	
	
}
