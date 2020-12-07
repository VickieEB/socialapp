package com.petproject.socialapp.controller;

import com.petproject.socialapp.dto.LocationDto;
import com.petproject.socialapp.model.Location;
import com.petproject.socialapp.service.LocationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LocationController {

    LocationService locationService;

    ModelMapper modelMapper;

    public LocationController(LocationService locationService, ModelMapper modelMapper) {
        this.locationService = locationService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/locations")
    public List<LocationDto> getAllLocations(){
        List<Location> locations = locationService.findAll();
        return locations.stream().map(this::convertToDto).collect(Collectors.toList());
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

    public LocationDto convertToDto(Location location){
        return modelMapper.map(location, LocationDto.class);
    }

}
