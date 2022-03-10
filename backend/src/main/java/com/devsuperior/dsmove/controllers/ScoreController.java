package com.devsuperior.dsmove.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devsuperior.dsmove.dto.MovieDTO;
import com.devsuperior.dsmove.dto.ScoreDTO;
import com.devsuperior.dsmove.services.ScoreService;

@RestController
@RequestMapping("/scores")
public class ScoreController {
  
  private ScoreService service;

  @Autowired
  public ScoreController(ScoreService service) {
    this.service = service;
  }

  @PutMapping
  public MovieDTO saveScore(@RequestBody ScoreDTO dto) {
    return service.saveScore(dto);
  }
}
