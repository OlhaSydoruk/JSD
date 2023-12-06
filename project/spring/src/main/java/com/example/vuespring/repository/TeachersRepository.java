package com.example.vuespring.repository;

import com.example.vuespring.entity.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeachersRepository extends JpaRepository<Teachers,Long> {
}
