package com.calil.dsmovie.services;

import com.calil.dsmovie.dto.MovieDto;
import com.calil.dsmovie.entities.Movie;
import com.calil.dsmovie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    @Transactional(readOnly = true)
    public Page<MovieDto> findAll(Pageable pageable) {
        Page<Movie> movies = repository.findAll(pageable);
        Page<MovieDto> moviesDto = movies.map(movie -> new MovieDto(movie));
        return moviesDto;
    }

    @Transactional(readOnly = true)
    public MovieDto findById(Long id) {
        Movie movie = repository.findById(id).get();
        MovieDto movieDto = new MovieDto(movie);
        return movieDto;
    }

}
