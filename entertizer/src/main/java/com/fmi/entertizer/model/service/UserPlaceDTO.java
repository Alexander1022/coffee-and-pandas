package com.fmi.entertizer.model.service;

public class UserPlaceDTO {
    private int userId;
    private int placeId;
    private int rating;
    private String review;

    public UserPlaceDTO(int userId, int placeId, int rating, String review) {
        this.userId = userId;
        this.placeId = placeId;
        this.rating = rating;
        this.review = review;
    }

    public UserPlaceDTO(int userId, int placeId) {
        this.userId = userId;
        this.placeId = placeId;
    }

    public UserPlaceDTO() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
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
