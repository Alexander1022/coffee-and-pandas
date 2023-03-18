package com.fmi.entertizer.repository;

import com.fmi.entertizer.model.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findFirstByEmail(String email);

    Optional<User> getUserById(Long id);
}
