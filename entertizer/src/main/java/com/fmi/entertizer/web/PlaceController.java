package com.fmi.entertizer.web;

import com.fmi.entertizer.model.service.EventDTO;
import com.fmi.entertizer.model.service.PlaceDTO;
import com.fmi.entertizer.model.service.UserPlaceRatingDTO;
import com.fmi.entertizer.model.service.UserPlaceReviewDTO;
import com.fmi.entertizer.service.PlaceService;
import com.fmi.entertizer.service.impl.PlaceServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3001")
@RequestMapping("/places")
public class PlaceController {
    private ModelMapper modelMapper;

    @Autowired
    private PlaceServiceImpl placeService;

    @RequestMapping(value = "/addreview", method= RequestMethod.GET)
    public void addComment(@RequestBody UserPlaceReviewDTO userPlaceReviewDTO){
        placeService.addARevueToAPlace(userPlaceReviewDTO.getUserId(), userPlaceReviewDTO.getPlaceId(), userPlaceReviewDTO.getReview());
    }

    @RequestMapping(value = "/addrating", method= RequestMethod.GET)
    public void addComment(@RequestBody UserPlaceRatingDTO userPlaceRatingDTO){
        placeService.ratePlace(userPlaceRatingDTO.getUserId(), userPlaceRatingDTO.getPlaceId(), userPlaceRatingDTO.getRating());
    }

}
