package com.epam;

import java.util.Arrays;

public class Arbiter {


    private static State checkState(Cell[] cells) {


        if (Arrays.stream(cells).anyMatch(cell -> cell.getPlayer() == Player.NONE)) return State.PLAYING;
        if (Arrays.stream(cells).allMatch(cell -> cell.getPlayer() == Player.X)) return State.X_WON;
        else if (Arrays.stream(cells).allMatch(cell -> cell.getPlayer() == Player.Y)) return State.Y_WON;
        return State.PLAYING;
    }

}
