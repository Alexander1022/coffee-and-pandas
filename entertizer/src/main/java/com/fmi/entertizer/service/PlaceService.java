package com.fmi.entertizer.service;

import com.fmi.entertizer.model.service.PlaceDTO;
import com.fmi.entertizer.model.service.UserDTO;

public interface PlaceService {

    PlaceDTO ratePlace(UserDTO userDTO, PlaceDTO placeDTO, int rating);

    PlaceDTO addARevueToAPlace(UserDTO userDTO, PlaceDTO placeDTO, String revue);
}
