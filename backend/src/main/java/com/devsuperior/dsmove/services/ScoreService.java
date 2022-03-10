package com.devsuperior.dsmove.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.devsuperior.dsmove.dto.MovieDTO;
import com.devsuperior.dsmove.dto.ScoreDTO;
import com.devsuperior.dsmove.entities.Movie;
import com.devsuperior.dsmove.entities.Score;
import com.devsuperior.dsmove.entities.ScorePK;
import com.devsuperior.dsmove.entities.User;
import com.devsuperior.dsmove.repositories.MovieRepository;
import com.devsuperior.dsmove.repositories.ScoreRepository;
import com.devsuperior.dsmove.repositories.UserRepository;

@Service
public class ScoreService {

  private MovieRepository movieRepository;
  private UserRepository userRepository;
  private ScoreRepository scoreRepository;

  @Autowired
  public ScoreService(MovieRepository movieRepository, UserRepository userRepository,
      ScoreRepository scoreRepository) {
    this.movieRepository = movieRepository;
    this.userRepository = userRepository;
    this.scoreRepository = scoreRepository;
  }

  @Transactional
  public MovieDTO saveScore(ScoreDTO dto) {
    User user = userRepository.findByEmail(dto.getEmail())
        .orElseGet(() -> userRepository.saveAndFlush(new User(null, dto.getEmail())));

    Movie movie = movieRepository.findById(dto.getMovieId()).get();

    scoreRepository.saveAndFlush(new Score(new ScorePK(movie, user), dto.getScore()));

    double sum = movie.getScores().stream().map(score -> score.getValue()).reduce(0.0, Double::sum);
    double avg = sum / movie.getScores().size();

    movie.setScore(avg);
    movie.setCount(movie.getScores().size());

    movie = movieRepository.save(movie);

    return new MovieDTO(movie);
  }
}
