package com.petproject.socialapp.service;
import com.petproject.socialapp.dto.StudentDto;
import com.petproject.socialapp.model.Student;
import com.petproject.socialapp.repositories.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class StudentService {


    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll(){
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    public void save(StudentDto studentDto){
        Student student = convertToEntity(studentDto);
        studentRepository.save(student);
    }

    public StudentDto findById(Long id){
        Student student = studentRepository.findById(id).orElse(null);
       return convertToDto(student);
    }

    public void deleteById(Long id){
        studentRepository.deleteById(id);
    }

    private StudentDto convertToDto(Student student){
        StudentDto studentDto = new StudentDto();
        BeanUtils.copyProperties(student, studentDto);
        return studentDto;
    }

    private Student convertToEntity(StudentDto studentDto){
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        return student;
    }

}
