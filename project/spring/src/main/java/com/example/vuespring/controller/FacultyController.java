package com.example.vuespring.controller;

import com.example.vuespring.entity.Faculty;
import com.example.vuespring.entity.Students;
import com.example.vuespring.repository.FacultyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculties")
@CrossOrigin("http://localhost:5173")
public class FacultyController {
    private final FacultyRepository facultyRepository;

    public FacultyController(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }
    @GetMapping
    public List<Faculty> listFaculties() {
        return  facultyRepository.findAll();
    }

    @GetMapping("/{id}")
    public Faculty getFaculty(@PathVariable long id) {
        return facultyRepository.getReferenceById(id);
    }

    @PostMapping
    public void insertFaculty(@RequestBody Faculty faculty) {
        facultyRepository.save(faculty);
    }

    @PutMapping
    public void updateFaculty(@RequestBody Faculty faculty) {
        Faculty existingFaculty = facultyRepository.getReferenceById(faculty.getId());
        existingFaculty.setName(faculty.getName());
        existingFaculty.setShortName(faculty.getShortName());
        facultyRepository.save(existingFaculty);
    }
    @DeleteMapping("/{id}")
    public void deleteFaculty(@PathVariable long id) {
        facultyRepository.deleteById(id);
    }
}
