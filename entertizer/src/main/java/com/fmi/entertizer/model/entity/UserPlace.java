package com.fmi.entertizer.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_place")
public class UserPlace extends BaseEntity{
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="place_id")
    private Place place;

    @Column
    private int rating;

    @Column
    private String revue;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getRevue() {
        return revue;
    }

    public void setRevue(String revue) {
        this.revue = revue;
    }
}
