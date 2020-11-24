package com.petproject.socialapp.controller;

import com.petproject.socialapp.model.Location;
import com.petproject.socialapp.service.LocationService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class LocationController {

    LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/locations")
    public List<Location> getAllLocations(){
        return locationService.findAll();
    }

    @GetMapping("/locations/{id}")
    public Location getLocationById(@PathVariable Long id){
        return locationService.findById(id);
    }

    @PostMapping("/locations")
    public void addLocation(@RequestBody Location location){
        locationService.save(location);
    }

    @PutMapping("/locations/{id}")
    public void updateLocation( @PathVariable Long id, @RequestBody Location location){
        Location existingLocation = locationService.findById(id);
        BeanUtils.copyProperties(location, existingLocation);
        locationService.save(existingLocation);
    }

    @DeleteMapping("/locations/{id}")
    public void deleteLocation(@PathVariable Long id){
        locationService.deleteById(id);
    }

}
