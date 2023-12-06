package com.example.vuespring.repository;


import com.example.vuespring.entity.Groups;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GroupRepository extends JpaRepository<Groups,Long> {
}
