package com.fmi.entertizer.model.service;

public class UserPlaceReviewDTO {
    private Long userId;
    private Long placeId;
    private String review;

    public UserPlaceReviewDTO(Long userId, Long placeId, String review) {
        this.userId = userId;
        this.placeId = placeId;
        this.review = review;
    }

    public UserPlaceReviewDTO() {
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

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
