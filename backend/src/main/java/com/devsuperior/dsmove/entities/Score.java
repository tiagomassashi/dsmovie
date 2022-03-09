package com.devsuperior.dsmove.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_score")
public class Score {

  @EmbeddedId
  private ScorePK id = new ScorePK();
  private Double value;

  public void setMovie(Movie movie) {
    this.id.setMovie(movie);
  }

  public void setUser(User user) {
    this.id.setUser(user);
  }
}
