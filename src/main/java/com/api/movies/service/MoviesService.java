package com.api.movies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.movies.model.AnswerModel;
import com.api.movies.model.MoviesModel;
import com.api.movies.repository.MoviesRepository;

@Service
public class MoviesService {

    @Autowired
    private MoviesRepository repository;

    @Autowired
    private AnswerModel answerModel;

    public Iterable<MoviesModel> list(){
        return repository.findAll();
    }

    public ResponseEntity<?> register(MoviesModel mModel){
        if(mModel.getName().equals("")){
            answerModel.setMessage("Movie name empty");
            return new ResponseEntity<AnswerModel>(answerModel, HttpStatus.BAD_REQUEST);
        }else if(mModel.getDirector().equals("")){
            answerModel.setMessage("Movie Director empty");
            return new ResponseEntity<AnswerModel>(answerModel, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<MoviesModel>(repository.save(mModel), HttpStatus.CREATED);
        }
    }

    public ResponseEntity<?> update(MoviesModel mModel){
        if(mModel.getName().equals("")){
            answerModel.setMessage("Movie name empty");
            return new ResponseEntity<AnswerModel>(answerModel, HttpStatus.BAD_REQUEST);
        }else if(mModel.getDirector().equals("")){
            answerModel.setMessage("Movie Director empty");
            return new ResponseEntity<AnswerModel>(answerModel, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<MoviesModel>(repository.save(mModel), HttpStatus.OK);
        }
    }

    public ResponseEntity<AnswerModel> remove(Long code){
       repository.deleteById(code);
       answerModel.setMessage("Movie removed with success !");
       return new ResponseEntity<AnswerModel>(answerModel, HttpStatus.OK);
    }

}
