package com.springdatajpa.controller;

import com.springdatajpa.dao.MovieRepository;
import com.springdatajpa.entyty.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;


    @GetMapping()
    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

    @PostMapping()
    @ResponseStatus(value = HttpStatus.CREATED)
    public Movie createMovie(@RequestBody Movie movie){
        return movieRepository.saveAndFlush(movie);
    }

    @PutMapping(value = "/{id}")
    public Movie updateMovie(@PathVariable long id, @RequestBody Movie movie){
        if(!movieRepository.existsById(id)){
            throw new IllegalArgumentException("No movie with such id - " + id);
        }
        movie.setId(id);
        return movieRepository.saveAndFlush(movie);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteMovie(@PathVariable long id){
        if(!movieRepository.existsById(id)){
            throw new IllegalArgumentException("No movie with such id - " + id);
        }
        movieRepository.deleteById(id);
    }

}
