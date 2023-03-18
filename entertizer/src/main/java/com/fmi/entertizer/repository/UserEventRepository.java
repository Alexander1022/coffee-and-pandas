package com.fmi.entertizer.repository;

import com.fmi.entertizer.model.entity.UserEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEventRepository extends JpaRepository<UserEvent, Long> {
    Optional<UserEvent> findAllByEventId(Long id);
    Optional<UserEvent> findAllByUserId(Long id);

    void deleteAllByUserId(Long id);

    void deleteAllByEventId(Long id);
}
