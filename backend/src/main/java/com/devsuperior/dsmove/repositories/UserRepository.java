package com.devsuperior.dsmove.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.devsuperior.dsmove.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByEmail(String email);
}
