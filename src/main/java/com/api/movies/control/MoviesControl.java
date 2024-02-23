package com.api.movies.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.api.movies.model.AnswerModel;
import com.api.movies.model.MoviesModel;
import com.api.movies.service.MoviesService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class MoviesControl {
    
    @Autowired
    private MoviesService service;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody MoviesModel mModel) {
        return service.register(mModel);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody MoviesModel mModel) {
        return service.update(mModel);
    }

    @DeleteMapping("/remove/{code}")
    public ResponseEntity<AnswerModel> remove(@PathVariable Long code) {
        return service.remove(code);
    }

    @GetMapping("/list")
    public Iterable<MoviesModel> list(){
        return service.list();
    }

    @GetMapping("/")
    public String route(){
        return "API Working";
    }
}
