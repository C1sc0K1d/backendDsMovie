package com.calil.dsmovie.dto;

import com.calil.dsmovie.entities.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {

    private Long id;

    private String title;

    private String description;

    private Double score;

    private Integer count;

    private String image;

    public MovieDto(Movie movie) {
        id = movie.getId();
        title = movie.getTitle();
        description = movie.getDescription();
        score = movie.getScore();
        count = movie.getCount();
        image = movie.getImage();
    }
}
