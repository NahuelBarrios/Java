package com.disney.dao;

import com.disney.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovieDao extends JpaRepository<Movie, Long>{
    
}
