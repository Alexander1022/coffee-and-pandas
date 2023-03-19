package com.fmi.entertizer.service.impl;

import com.fmi.entertizer.model.entity.Place;
import com.fmi.entertizer.model.entity.User;
import com.fmi.entertizer.model.entity.UserPlace;
import com.fmi.entertizer.model.service.PlaceDTO;
import com.fmi.entertizer.model.service.UserDTO;
import com.fmi.entertizer.repository.EventRepository;
import com.fmi.entertizer.repository.PlaceRepository;
import com.fmi.entertizer.repository.UserPlaceRepository;
import com.fmi.entertizer.repository.UserRepository;
import com.fmi.entertizer.service.PlaceService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//TODO: add place methods
//TODO: rating revues
@Service
public class PlaceServiceImpl implements PlaceService {
    private final ModelMapper modelMapper;
    private final PlaceRepository placeRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    private final UserPlaceRepository userPlaceRepository;

    public PlaceServiceImpl(ModelMapper modelMapper, PlaceRepository placeRepository, UserRepository userRepository, EventRepository eventRepository, UserPlaceRepository userPlaceRepository) {
        this.modelMapper = modelMapper;
        this.placeRepository = placeRepository;
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
        this.userPlaceRepository = userPlaceRepository;
    }

    @Override
    public void ratePlace(Long userId, Long placeId,  int rating) {
        UserPlace userPlace = new UserPlace(modelMapper.map(this.userRepository.findFirstById(userId).orElse(null), User.class), modelMapper.map(this.placeRepository.findFirstById(placeId).orElse(null), Place.class));
        userPlace.setRating(rating);
        UserPlace current = this.userPlaceRepository.findUserPlaceByUserIdAndPlaceId(userId, placeId).orElse(null);
        if (current != null) {
            current.setRating(rating);
            this.userPlaceRepository.save(current);
        } else {
            this.userPlaceRepository.save(userPlace);
        }
    }

    @Override
    public void addARevueToAPlace(Long userId, Long placeId, String review) {
        UserPlace userPlace = new UserPlace(modelMapper.map(this.userRepository.findFirstById(userId).orElse(null), User.class), modelMapper.map(this.placeRepository.findFirstById(placeId), Place.class));
        userPlace.setReview(review);
        UserPlace current = this.userPlaceRepository.findUserPlaceByUserIdAndPlaceId(userId, placeId).orElse(null);
        if (current != null) {
            current.setReview(review);
            this.userPlaceRepository.save(current);
        } else {
            this.userPlaceRepository.save(userPlace);
        }
    }

    @Override
    public List <String> allUserReviewsByPlace(Long placeId){
        Place place = this.placeRepository.findFirstById(placeId).orElse(null);
        List<String> reviews = new ArrayList<>();
        if(place.getPlaceUser() != null) place.getPlaceUser().forEach(pu->reviews.add(pu.getReview()));
        return reviews;
    }

}
