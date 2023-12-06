package com.example.vuespring.repository;


import com.example.vuespring.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Students,Long>  {
}
