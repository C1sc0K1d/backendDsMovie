package com.calil.dsmovie.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
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

    @OneToMany(mappedBy = "id.movie")
    private final Set<Score> scores = new HashSet<>();
}
