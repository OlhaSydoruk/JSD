package com.example.vuespring.controller;

import com.example.vuespring.entity.Groups;
import com.example.vuespring.repository.GroupRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
@CrossOrigin("http://localhost:5173")
public class GroupsController {
    private final GroupRepository groupRepository;


    public GroupsController(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @GetMapping
    public List<Groups> listGroups() {
        return groupRepository.findAll();
    }

    @GetMapping("/{id}")
    public Groups getGroups(@PathVariable long id) {
        return groupRepository.getReferenceById(id);
    }

    @PostMapping
    public void insertGroups(@RequestBody Groups groups) {
        groupRepository.save(groups);
    }

    @PutMapping
    public void updateGroups(@RequestBody Groups groups) {
        Groups existingGroups = groupRepository.getReferenceById(groups.getId());
        existingGroups.setName(groups.getName());
        existingGroups.setCourse(groups.getCourse());
        existingGroups.setDepartmentId(groups.getDepartmentId());
        groupRepository.save(existingGroups);
    }

    @DeleteMapping("/{id}")
    public void deleteGroups(@PathVariable long id) {
        groupRepository.deleteById(id);
    }
}

