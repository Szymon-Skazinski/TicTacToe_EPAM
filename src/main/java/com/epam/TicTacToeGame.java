package com.epam;

import java.io.InputStream;
import java.io.PrintStream;

public class TicTacToeGame {

    private static final int SIZE = 3;
    private final UI ui;
    private Board board;


    public TicTacToeGame(InputStream in, PrintStream out) {
        this.ui = new UI(in, out);
    }

    void gameInit() {
        board = createBoard(SIZE);
        ui.intro();
        gameLoop();
    }

    private void gameLoop() {
        Player currentPlayer = Player.X;

        while (Arbiter.judge(board) == State.PLAYING) {
            ui.showMessage("It's your turn Mr." + currentPlayer + "\n");
            Cell cell = chooseCell();
            cell.setPlayer(currentPlayer);
            currentPlayer = switchPlayer(currentPlayer);
            ui.printBoard(board);
        }

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

    private Cell chooseCell() {
        Cell cell;
        do {
            ui.showMessage("Please choose number of cell: \n");
            int cellPosition = ui.getCellNumber();
            cell = ui.getCellByPosition(cellPosition, board);

            if (cell.getPlayer().equals(Player.X) || cell.getPlayer().equals(Player.Y)) {
                ui.showMessage("Cell is not empty. Try again.");
            }
        } while (!cell.isEmpty());
        return cell;
    }

    private Player switchPlayer(Player currentPlayer) {
        switch (currentPlayer) {
            case X:
                return Player.Y;
            case Y:
                return Player.X;
            default:
                return Player.NONE;
        }
    }


}
