package com.epam;

public enum  Player {
    X(false),
    Y(false),
    NONE;

    private boolean active;

    Player() {
    }

    Player(boolean active) {
        this.active = active;
    }

}
