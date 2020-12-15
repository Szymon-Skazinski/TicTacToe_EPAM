package com.epam;

public enum Player {
    X(false),
    Y(false),
    NONE {
        @Override
        public String toString() {
            return " ";
        }
    };

    private boolean active;

    Player() {
    }

    Player(boolean active) {
        this.active = active;
    }

}
