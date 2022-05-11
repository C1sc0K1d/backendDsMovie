package com.calil.dsmovie.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_MOVIE")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description", length = 800)
    private String description;

    @Column(name = "score")
    private Double score;

    @Column(name = "count")
    private Integer count;

    @Column(name = "image")
    private String image;

}
