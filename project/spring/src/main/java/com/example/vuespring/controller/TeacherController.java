package com.example.vuespring.controller;

import com.example.vuespring.entity.Students;
import com.example.vuespring.entity.Teachers;
import com.example.vuespring.repository.TeachersRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
@CrossOrigin("http://localhost:5173")
public class TeacherController {
    private final TeachersRepository teachersRepository;
    public TeacherController(TeachersRepository teachersRepository){
        this.teachersRepository=teachersRepository;
    }
@RequestMapping
    public List<Teachers> listTeachers (){
        return teachersRepository.findAll();
}
@RequestMapping("/{id}")
    public Teachers getTeacherById(@PathVariable long id){
        return teachersRepository.getReferenceById(id);
}
@PostMapping
    public void insertTeacher(@RequestBody Teachers teachers){
        teachersRepository.save(teachers);
}
    @PutMapping
    public void updateTeacher(@RequestBody Teachers teachers) {
        Teachers existingTeacher = teachersRepository.getReferenceById(teachers.getId());
        existingTeacher.setName(teachers.getName());
        existingTeacher.setSurname(teachers.getSurname());
        existingTeacher.setEmail(teachers.getEmail());
        teachersRepository.save(existingTeacher);
    }
    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable long id) {
        teachersRepository.deleteById(id);
    }
}
