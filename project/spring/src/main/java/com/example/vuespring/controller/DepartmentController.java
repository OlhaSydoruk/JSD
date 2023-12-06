package com.example.vuespring.controller;

import com.example.vuespring.entity.Department;
import com.example.vuespring.entity.Disciplines;
import com.example.vuespring.repository.DepartmentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@CrossOrigin("http://localhost:5173")

public class DepartmentController {

    private final DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @GetMapping
    public List<Department> listDepartments() {
        return  departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable long id) {
        return departmentRepository.getReferenceById(id);
    }

    @PostMapping
    public void insertDepartment(@RequestBody Department department) {
        departmentRepository.save(department);
    }

    @PutMapping
    public void updateDepartment(@RequestBody Department department) {
        Department existingDepartment = departmentRepository.getReferenceById(department.getId());
        existingDepartment.setName(department.getName());
        existingDepartment.setFacultyId(department.getFacultyId());
        existingDepartment.setShortName(department.getShortName());
        departmentRepository.save(existingDepartment);
    }
    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable long id) {
        departmentRepository.deleteById(id);
    }
}
