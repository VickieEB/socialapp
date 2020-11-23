package com.petproject.socialapp.service;

import com.petproject.socialapp.model.Location;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LocationService {

    Location lagos = Location.builder().id(1L).name("Lagos State").build();
    Location abuja = Location.builder().id(2L).name("South Africa").build();
    List<Location> locations = new ArrayList<>(Arrays.asList(lagos, abuja));

    public List<Location> findAll(){
        return locations;
    }

    public Location findById(Long id){
        return locations.stream().filter(l -> id.equals(l.getId())).findFirst().orElse(null);
    }

    public void save(Location location) {
        locations.add(location);
    }


    public void updateLocation(Long id, Location location) {
//        for (int i = 0; i < locations.size(); i++) {
//            Location l  = locations.get(i);
//
//            if(l.getId().equals(id)){
//                locations.set(i, location);
//            }
//        }
//
        //One Lambda way
//        locations.forEach(locationToModify -> {
//            if(locationToModify.getId() == location.getId()){
//                locationToModify.setName(location.getName());
//            }
//        });

        locations.stream()
                .filter(locationToModify -> locationToModify.getId() == location.getId())
                .findAny().ifPresent(locationToModify -> locationToModify.setName(location.getName()));
    }

    public void deleteById(Long id) {
        locations.removeIf(locationToDelete -> locationToDelete.getId().equals(id));
    }
}
