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
    public PlaceDTO ratePlace(UserDTO userDTO, PlaceDTO placeDTO, int rating) {
        UserPlace userPlace = new UserPlace(modelMapper.map(userDTO, User.class), modelMapper.map(placeDTO, Place.class));
        userPlace.setRating(rating);
        UserPlace current = this.userPlaceRepository.findUserPlaceByUserIdAndPlaceId(userDTO.getId(), this.placeRepository.findFirstByCoordinates(placeDTO.getCoordinates()).get().getId()).orElse(null);
        if (current != null) {
            current.setRating(rating);
            this.userPlaceRepository.save(current);
        } else {
            this.userPlaceRepository.save(userPlace);
        }
        return placeDTO;
    }

    @Override
    public PlaceDTO addARevueToAPlace(UserDTO userDTO, PlaceDTO placeDTO, String review) {
        UserPlace userPlace = new UserPlace(modelMapper.map(userDTO, User.class), modelMapper.map(placeDTO, Place.class));
        userPlace.setReview(review);
        UserPlace current = this.userPlaceRepository.findUserPlaceByUserIdAndPlaceId(userDTO.getId(), this.placeRepository.findFirstByCoordinates(placeDTO.getCoordinates()).get().getId()).orElse(null);
        if (current != null) {
            current.setReview(review);
            this.userPlaceRepository.save(current);
        } else {
            this.userPlaceRepository.save(userPlace);
        }
        return placeDTO;
    }

    //TODO: add reviews
}
