package com.petproject.socialapp.controller;

import com.petproject.socialapp.dto.LocationDto;
import com.petproject.socialapp.model.Location;
import com.petproject.socialapp.service.LocationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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
    public LocationDto getLocationById(@PathVariable Long id){
        return convertToDto(locationService.findById(id));
    }

    @PostMapping("/locations")
    public void addLocation(@RequestBody LocationDto locationDto){
        Location location = convertToEntity(locationDto);
        locationService.save(location);
    }

    @PutMapping("/locations/{id}")
    public void updateLocation( @PathVariable Long id, @RequestBody LocationDto locationDto){
        Location existingLocation = locationService.findById(id);
        BeanUtils.copyProperties(convertToEntity(locationDto), existingLocation);
        locationService.save(existingLocation);
    }

    @DeleteMapping("/locations/{id}")
    public void deleteLocation(@PathVariable Long id){
        locationService.deleteById(id);
    }

    private LocationDto convertToDto(Location location){
        return modelMapper.map(location, LocationDto.class);
    }

    private Location convertToEntity(LocationDto locationDto) {
        Location location = modelMapper.map(locationDto, Location.class);
//        if (locationDto.getId() != null){
//            Location oldLocation = locationService.findById(locationDto.getId());
//
//        }
        return location;
    }

}
