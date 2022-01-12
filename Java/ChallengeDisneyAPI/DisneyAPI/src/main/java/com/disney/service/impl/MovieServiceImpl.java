package com.disney.service.impl;

import com.disney.dao.IMovieDao;
import com.disney.entities.Movie;
import com.disney.service.IMovieService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements IMovieService{
    
    @Autowired
    private IMovieDao movieDao;
    
    @Override
     public void save(Movie movie)
    {
        movieDao.save(movie);
    }

     @Override
     public List<Movie> listMovies()
     {
         return (List<Movie>) movieDao.findAll();
     }
    
}
