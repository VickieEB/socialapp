package com.petproject.socialapp.repositories;

import com.petproject.socialapp.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
