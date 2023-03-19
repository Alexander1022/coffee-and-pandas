package com.fmi.entertizer.model.service;

public class UserPlaceRatingDTO {
    private Long userId;
    private Long placeId;
    private int rating;

    public UserPlaceRatingDTO(Long userId, Long placeId, int rating) {
        this.userId = userId;
        this.placeId = placeId;
        this.rating = rating;
    }

    public UserPlaceRatingDTO() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
