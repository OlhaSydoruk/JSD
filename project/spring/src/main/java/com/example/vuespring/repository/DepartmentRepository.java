package com.example.vuespring.repository;

import com.example.vuespring.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
