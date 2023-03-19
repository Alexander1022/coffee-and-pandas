package com.fmi.entertizer.model.service;

public class FriendAcceptingDTO {
    public Long id1;
    public Long id2;
    public Boolean accepted;

    public FriendAcceptingDTO() {
    }

    public Long getId1() {
        return id1;
    }

    public void setId1(Long id1) {
        this.id1 = id1;
    }

    public Long getId2() {
        return id2;
    }

    public void setId2(Long id2) {
        this.id2 = id2;
    }

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }
}