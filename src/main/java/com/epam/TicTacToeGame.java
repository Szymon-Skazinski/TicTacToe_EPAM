package com.epam;

public class TicTacToeGame {

    private Board createBoard(int size) {

        Cell[][] cells = new Cell[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new Cell(Player.NONE);
            }
        }
        return new Board(cells);
    }
}
