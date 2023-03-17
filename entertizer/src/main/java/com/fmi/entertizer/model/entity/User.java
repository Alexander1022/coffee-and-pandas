package com.fmi.entertizer.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true, updatable = true)
    @Email
    private String email;

    @Column(nullable = false, updatable = true)
    @Length(min = 3, message = "Password must be at least 3 characters.")
    private String password;

    @Column(nullable = false)
    private String coordinates;

    @OneToOne(mappedBy ="creator")
    private Event event;

    public User(String firstName, String lastName, String email, String password, String coordinates) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.coordinates = coordinates;
    }
    public User(){}



    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<UserPlace> getUserPlace() {
        return userPlace;
    }

    public void setUserPlace(List<UserPlace> userPlace) {
        this.userPlace = userPlace;
    }

    public List<UserEvent> getUserEvent() {
        return userEvent;
    }

    public void setUserEvent(List<UserEvent> userEvent) {
        this.userEvent = userEvent;
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }


    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    private List<UserPlace> userPlace = new ArrayList<>();

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    private List<UserEvent> userEvent = new ArrayList<>();

    @OneToMany(mappedBy = "firstUser", cascade = CascadeType.ALL)
    private List<Friend> friends = new ArrayList<>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }
}