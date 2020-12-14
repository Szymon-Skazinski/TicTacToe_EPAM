package com.epam;

public class TicTacToeGame {

    private final int size;
    private final UI ui;

    public TicTacToeGame(int size, UI ui) {
        this.size = size;
        this.ui = ui;
    }


    void gameInit() {
        createBoard(size);
        UI ui = new UI(System.in, System.out);
    }

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
