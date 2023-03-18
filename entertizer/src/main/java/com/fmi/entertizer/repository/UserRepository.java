package com.fmi.entertizer.repository;

import com.fmi.entertizer.model.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findFirstByEmail(String email);
    Optional<User> findFirstByCoordinates(String coordinates);

    Optional<User> findFirstById(Long id);


    @Modifying
    @Transactional
    @Query(value = "select * from User ", nativeQuery = true)
    Optional<User> getAll();

    Optional<User> getUserById(Long id);
}
