package com.fmi.entertizer.model.service;

import com.fmi.entertizer.model.entity.enums.Status;

public class FriendDTO {
    Long firstUserId;
    Long secondUserId;

    Status status;

    public FriendDTO(Long firstUserId, Long secondUserId, Status status) {
        this.firstUserId = firstUserId;
        this.secondUserId = secondUserId;
        this.status = status;
    }

    public Long getFirstUserId() {
        return firstUserId;
    }

    public void setFirstUserId(Long firstUserId) {
        this.firstUserId = firstUserId;
    }

    public Long getSecondUserId() {
        return secondUserId;
    }

    public void setSecondUserId(Long secondUserId) {
        this.secondUserId = secondUserId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
