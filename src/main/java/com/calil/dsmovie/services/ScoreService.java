package com.calil.dsmovie.services;

import com.calil.dsmovie.dto.MovieDto;
import com.calil.dsmovie.dto.ScoreDto;
import com.calil.dsmovie.entities.Movie;
import com.calil.dsmovie.entities.Score;
import com.calil.dsmovie.entities.User;
import com.calil.dsmovie.repositories.MovieRepository;
import com.calil.dsmovie.repositories.ScoreRepository;
import com.calil.dsmovie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDto saveScore(ScoreDto scoreDto) {

        User user = userRepository.findByEmail(scoreDto.getEmail());
        if (user == null) {
            user = new User();
            user.setEmail(scoreDto.getEmail());
            user = userRepository.save(user);
        }

        Movie movie = movieRepository.findById(scoreDto.getMovieId()).get();

        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(scoreDto.getScore());

        scoreRepository.saveAndFlush(score);

        double scoreSum = 0.0;
        for (Score s : movie.getScores()) {
            scoreSum = scoreSum + s.getValue();
        }

        double avgScore = scoreSum / movie.getScores().size();

        movie.setScore(avgScore);
        movie.setCount (movie.getScores().size());

        movie = movieRepository.save(movie);

        return new MovieDto(movie);
    }

}
