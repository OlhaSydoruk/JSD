package com.example.vuespring.repository;
import com.example.vuespring.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {

}

