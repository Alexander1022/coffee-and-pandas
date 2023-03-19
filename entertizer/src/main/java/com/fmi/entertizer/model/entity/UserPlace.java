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
    private String review;

    public UserPlace() {
    }

    public UserPlace(User user, Place place) {
        this.user = user;
        this.place = place;
    }

    public UserPlace(User user, Place place, int rating, String revue) {
        this.user = user;
        this.place = place;
        this.rating = rating;
        this.review = review;
    }

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

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
