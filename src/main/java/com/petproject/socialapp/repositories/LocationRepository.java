package com.petproject.socialapp.repositories;

import com.petproject.socialapp.model.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Long> {
}
