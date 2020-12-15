package com.epam;

public class TicTacToeGame {

    private final int size;
    private final UI ui;
    private Board board;


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
