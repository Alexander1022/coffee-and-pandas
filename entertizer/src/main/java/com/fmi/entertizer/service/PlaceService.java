package com.fmi.entertizer.service;

import com.fmi.entertizer.model.service.PlaceDTO;
import com.fmi.entertizer.model.service.UserDTO;

import java.util.List;

public interface PlaceService {

    PlaceDTO ratePlace(UserDTO userDTO, PlaceDTO placeDTO, int rating);

    PlaceDTO addARevueToAPlace(UserDTO userDTO, PlaceDTO placeDTO, String revue);

    List<String> allUserReviewsByPlace(Long placeId);
}
