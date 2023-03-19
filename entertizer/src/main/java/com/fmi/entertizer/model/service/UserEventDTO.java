package com.fmi.entertizer.model.service;

import com.fmi.entertizer.model.entity.enums.Status;

public class UserEventDTO {
    private Long userId;
    private Long eventId;
    private Status status;

    public UserEventDTO() {
    }

    public UserEventDTO(Long userId, Long eventId, Status status) {
        this.userId = userId;
        this.eventId = eventId;
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
