package com.example.vuespring.repository;


import com.example.vuespring.entity.Disciplines;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DisciplinesRepository extends JpaRepository<Disciplines,Long> {
}
