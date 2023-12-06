package com.example.vuespring.controller;
import com.example.vuespring.entity.News;
import com.example.vuespring.repository.NewsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
@CrossOrigin("http://localhost:5173")
public class NewsController {
    private final NewsRepository newsRepository;
 public NewsController (NewsRepository newsRepository){
     this.newsRepository=newsRepository;
 }
    @GetMapping
    public List<News> listNews() {
        return  newsRepository.findAll();
    }

    @GetMapping("/{id}")
    public News getNews(@PathVariable long id) {
        return newsRepository.getReferenceById(id);
    }

    @PostMapping
    public void insertNews(@RequestBody News news) {
        newsRepository.save(news);
    }

    @PutMapping
    public void updateNews(@RequestBody News news) {
        News existingNews = newsRepository.getReferenceById(news.getId());
        existingNews.setFotoWay(news.getFotoWay());
        existingNews.setText(news.getText());
        newsRepository.save(existingNews);
    }
    @DeleteMapping("/{id}")
    public void deleteNews(@PathVariable long id) {
        newsRepository.deleteById(id);
    }
}

