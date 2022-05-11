package com.calil.dsmovie.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_SCORE")
public class Score {

    @EmbeddedId
    @Column(name = "id")
    private final ScorePk id = new ScorePk();

    @Column(name = "value")
    private Double value;

    public void setMovie(Movie movie) {
        id.setMovie(movie);
    }

    public void setUser(User user) {
        id.setUser(user);
    }

}
