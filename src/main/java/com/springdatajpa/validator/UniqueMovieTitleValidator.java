package com.springdatajpa.validator;

import com.springdatajpa.dao.MovieRepository;
import com.springdatajpa.entyty.Movie;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueMovieTitleValidator implements ConstraintValidator<UniqueMovieTitle, String> {

    private MovieRepository movieRepository;

    @Autowired
    public UniqueMovieTitleValidator(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void initialize(UniqueMovieTitle constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Movie movie = movieRepository.findByTitle(s);
        return movie == null;
    }
}
