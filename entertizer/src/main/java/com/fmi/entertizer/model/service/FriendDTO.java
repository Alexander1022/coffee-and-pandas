package com.fmi.entertizer.model.service;

public class FriendDTO {
    int firstUserId;
    int secondUserId;

    int status;

    public FriendDTO(int firstUserId, int secondUserId, int status) {
        this.firstUserId = firstUserId;
        this.secondUserId = secondUserId;
        this.status = status;
    }

    public int getFirstUserId() {
        return firstUserId;
    }

    public void setFirstUserId(int firstUserId) {
        this.firstUserId = firstUserId;
    }

    public int getSecondUserId() {
        return secondUserId;
    }

    public void setSecondUserId(int secondUserId) {
        this.secondUserId = secondUserId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
