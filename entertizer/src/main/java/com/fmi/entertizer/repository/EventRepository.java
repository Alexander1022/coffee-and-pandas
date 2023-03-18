package com.fmi.entertizer.repository;

import com.fmi.entertizer.model.entity.Event;
import com.fmi.entertizer.model.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    Optional<Event> findFirstById(Long id);

    @Modifying
    @Transactional
    @Query(value = "select * from Event ", nativeQuery = true)
    Optional<Event> getAll();


    @Modifying
    @Transactional
    @Query("delete from Event e where e.date < :dueDate")
    void deleteEventsByDueDateBefore(@Param("dueDate") LocalDate dueDate);
}
