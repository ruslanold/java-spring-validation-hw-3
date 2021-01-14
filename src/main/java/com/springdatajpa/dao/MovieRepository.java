package com.springdatajpa.dao;

import com.springdatajpa.entyty.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
