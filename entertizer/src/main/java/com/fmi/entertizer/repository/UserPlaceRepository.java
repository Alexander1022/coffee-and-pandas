package com.fmi.entertizer.repository;

import com.fmi.entertizer.model.entity.UserPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPlaceRepository extends JpaRepository<UserPlace, Long> {
}
