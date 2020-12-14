package com.epam;

public enum  Player {
    X(false),
    Y(false),
    NONE;

    boolean active;

    Player() {
    }

    Player(boolean active) {
        this.active = active;
    }

}
