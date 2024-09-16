package com.gm2.backendapp.controller;

import com.gm2.backendapp.entity.News;
import com.gm2.backendapp.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/news")
public class NewsController {

    private NewsRepository newsRepository;
    private NewsController(@Autowired NewsRepository newsRepository){
        this.newsRepository = newsRepository;
    }

    @GetMapping
    public ResponseEntity getAll(){
        return new ResponseEntity(newsRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody News news){
        try{
            news.setDate(new Date());
            newsRepository.save(news);
            return new ResponseEntity(news, HttpStatus.CREATED);
        } catch (Exception error){
            return new ResponseEntity(error.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
