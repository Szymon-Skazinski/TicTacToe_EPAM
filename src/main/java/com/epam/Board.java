package com.epam;

public class Board {
    private final Cell[][] board;


    public Board(Cell[][] board) {
        this.board = board;
    }

    public Cell[][] getBoard() {
        return board;
    }

    public Cell getCell(int row, int column){
        return board[row][column];
    }


}
