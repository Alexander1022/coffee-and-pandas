package com.fmi.entertizer.repository;

import com.fmi.entertizer.model.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    Optional<Place> findFirstById(Long id);

    Optional<Place> findFirstByCoordinates(String coordinates);
}
