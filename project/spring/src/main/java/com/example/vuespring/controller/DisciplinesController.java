package com.example.vuespring.controller;


import com.example.vuespring.entity.Disciplines;
import com.example.vuespring.entity.Faculty;
import com.example.vuespring.entity.Students;
import com.example.vuespring.repository.DisciplinesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplines")
@CrossOrigin("http://localhost:5173")
public class DisciplinesController {
    private final DisciplinesRepository disciplinesRepository;

    public DisciplinesController(DisciplinesRepository disciplinesRepository) {
        this.disciplinesRepository = disciplinesRepository;
    }
    @GetMapping
    public List<Disciplines> listDisciplines() {
        return  disciplinesRepository.findAll();
    }

    @GetMapping("/{id}")
    public Disciplines getDiscipline(@PathVariable long id) {
        return disciplinesRepository.getReferenceById(id);
    }

    @PostMapping
    public void insertDiscipline(@RequestBody Disciplines disciplines) {
        disciplinesRepository.save(disciplines);
    }

    @PutMapping
    public void updateDiscipline(@RequestBody Disciplines disciplines) {
        Disciplines existingDisciplines = disciplinesRepository.getReferenceById(disciplines.getId());
        existingDisciplines.setName(disciplines.getName());
        disciplinesRepository.save(existingDisciplines);
    }
    @DeleteMapping("/{id}")
    public void deleteDiscipline(@PathVariable long id) {
        disciplinesRepository.deleteById(id);
    }
}

