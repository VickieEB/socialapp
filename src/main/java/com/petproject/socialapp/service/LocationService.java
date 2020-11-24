package com.petproject.socialapp.service;

import com.petproject.socialapp.model.Location;
import com.petproject.socialapp.repositories.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LocationService {

    public final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> findAll(){
        List<Location> locations = new ArrayList<>();
        locationRepository.findAll().forEach(locations::add);
        return locations;
    }

    public Location findById(Long id){
        return locationRepository.findById(id).orElse(null);
    }

    public void save(Location location){
        locationRepository.save(location);
    }

    public void deleteById(Long id){
        locationRepository.deleteById(id);
    }

    public void delete(Location location){
        locationRepository.delete(location);
    }


}
