package com.example.project2;

public class Invitation {

    private User user;
    private Event event;

    public Invitation(User user, Event event) {
        this.user = user;
        this.event = event;
    }

    public void changeState(int state) {
        // later
    }
}
