package com.fmi.entertizer.repository;

import com.fmi.entertizer.model.entity.Friend;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Long> {
    @Transactional
    void deleteByFirstUserIdAndSecondUserId(Long firstId, Long secondId);
}
