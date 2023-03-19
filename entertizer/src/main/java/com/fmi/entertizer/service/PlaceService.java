package com.fmi.entertizer.service;

import com.fmi.entertizer.model.service.PlaceDTO;
import com.fmi.entertizer.model.service.UserDTO;

import java.util.List;

public interface PlaceService {

    public void ratePlace(Long userId, Long placeId,  int rating);

    public void addARevueToAPlace(Long userId, Long placeId, String review);

    List<String> allUserReviewsByPlace(Long placeId);
}
