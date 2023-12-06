package com.example.vuespring.repository;


import com.example.vuespring.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FacultyRepository extends JpaRepository<Faculty,Long> {
}
