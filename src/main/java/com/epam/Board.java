package com.epam;

public class Board {
    private final Cell[][] board;

    public Board() {
        this.board = new Cell[][]{
                {new Cell(Player.NONE), new Cell(Player.NONE), new Cell(Player.NONE)},
                {new Cell(Player.NONE), new Cell(Player.NONE), new Cell(Player.NONE)},
                {new Cell(Player.NONE), new Cell(Player.NONE), new Cell(Player.NONE)}
        };
    }

    public Cell[][] getBoard() {
        return board;
    }

}
