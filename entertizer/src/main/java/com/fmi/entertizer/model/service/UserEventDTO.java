package com.fmi.entertizer.model.service;

public class UserEventDTO {
    private Long userId;
    private Long eventId;
    private Long status;

    public UserEventDTO() {
    }

    public UserEventDTO(Long userId, Long eventId, Long status) {
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

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
}
