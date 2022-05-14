package com.calil.dsmovie.controllers;

import com.calil.dsmovie.dto.MovieDto;
import com.calil.dsmovie.dto.ScoreDto;
import com.calil.dsmovie.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PutMapping
    public MovieDto saveScore(@RequestBody ScoreDto scoreDto ) {
        return scoreService.saveScore(scoreDto);
    }

}
