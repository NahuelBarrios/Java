package com.disney.service;

import com.disney.entities.Movie;
import java.util.List;

public interface IMovieService {
    
    public void save(Movie movie);
    public List<Movie> listMovies();
}
