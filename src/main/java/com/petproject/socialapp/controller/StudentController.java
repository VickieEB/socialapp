package com.petproject.socialapp.controller;

import com.petproject.socialapp.dto.StudentDto;
import com.petproject.socialapp.model.Student;
import com.petproject.socialapp.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.findAll();
    }

    @GetMapping("/students/{id}")
    public StudentDto getStudent(@PathVariable Long id){
        return studentService.findById(id);
    }

    @PostMapping("/students")
    public void addStudent(@RequestBody StudentDto studentDto){
        studentService.save(studentDto);
        log.debug("Student Added");
    }

    @PutMapping("/students/{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody StudentDto studentDto){
        StudentDto studentToUpdate = studentService.findById(id);
        BeanUtils.copyProperties(studentDto, studentToUpdate, "id");
        studentService.save(studentToUpdate);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteById(id);
    }
}
