package com.api.movies.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.movies.model.MoviesModel;

@Repository
public interface MoviesRepository extends CrudRepository<MoviesModel, Long>{
    
}
