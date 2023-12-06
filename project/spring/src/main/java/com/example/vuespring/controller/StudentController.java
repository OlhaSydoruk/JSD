package com.example.vuespring.controller;

import com.example.vuespring.entity.Students;
import com.example.vuespring.repository.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin("http://localhost:5173")
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository
    ) {
        this.studentRepository = studentRepository;
    }


    @GetMapping
    public List<Students> listStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Students getStudent(@PathVariable long id) {
        return studentRepository.getReferenceById(id);
    }

    @PostMapping
    public void insertStudent(@RequestBody Students student) {
        studentRepository.save(student);
    }

    @PutMapping
    public void updateStudent(@RequestBody Students student) {
        Students existingStudent = studentRepository.getReferenceById(student.getId());
        existingStudent.setName(student.getName());
        existingStudent.setGroupId(student.getGroupId());
        existingStudent.setEmail(student.getEmail());
        studentRepository.save(existingStudent);
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable long id) {
        studentRepository.deleteById(id);
    }
}
