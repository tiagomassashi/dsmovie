package com.devsuperior.dsmove.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.devsuperior.dsmove.dto.MovieDTO;
import com.devsuperior.dsmove.entities.Movie;
import com.devsuperior.dsmove.repositories.MovieRepository;

@Service
public class MovieService {

  private MovieRepository repository;

  @Autowired
  public MovieService(MovieRepository repository) {
    this.repository = repository;
  }

  @Transactional(readOnly = true)
  public Page<MovieDTO> findAll(Pageable pageable) {
    return repository.findAll(pageable).map(MovieDTO::new);
  }

  @Transactional(readOnly = true)
  public MovieDTO findById(Long id) {
    Movie movie = repository.findById(id).get();
    return new MovieDTO(movie);
  }
}
