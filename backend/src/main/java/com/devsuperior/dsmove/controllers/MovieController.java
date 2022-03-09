package com.devsuperior.dsmove.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devsuperior.dsmove.dto.MovieDTO;
import com.devsuperior.dsmove.services.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

  private MovieService service;

  @Autowired
  public MovieController(MovieService service) {
    this.service = service;
  }

  @GetMapping
  public Page<MovieDTO> findAll(Pageable pageable) {
    return service.findAll(pageable);
  }

  @GetMapping("{id}")
  public MovieDTO findById(@PathVariable Long id) {
    return service.findById(id);
  }
}
