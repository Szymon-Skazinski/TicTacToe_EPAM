package com.epam;

import java.util.Arrays;

public class Arbiter {

    public static State judge(Board board) {

        State state;

        state = checkHorizontalWin(board);
        if (state != State.PLAYING) {
            System.out.println("Horizontal win");
            return state;
        }

        state = checkVerticalWin(board);
        if (state != State.PLAYING) {
            System.out.println("Vertical win");
            return state;
        }

        state = checkDiagonalWin(board);
        if (checkDiagonalWin(board) != State.PLAYING) {
            System.out.println("Diagonal win");
            return state;
        }


        return state;
    }


    private static State checkHorizontalWin(Board board) {
        State state = State.PLAYING;

        for (Cell[] row : board.getBoard()) {
            state = checkState(row);
            if (state != State.PLAYING) return state;
        }
        return state;
    }

    private static State checkVerticalWin(Board board) {
        State state = State.PLAYING;

        for (int i = 0; i < 3; i++) {

            Cell[] column = new Cell[]{
                    board.getCell(0, i),
                    board.getCell(1, i),
                    board.getCell(2, i)
            };
            state = checkState(column);

            if (state != State.PLAYING) return state;
        }

        return state;
    }

    private static State checkDiagonalWin(Board board) {
        State state;

        Cell[] diagonal1 = new Cell[]{
                board.getCell(0, 0),
                board.getCell(1, 1),
                board.getCell(2, 2)
        };
        Cell[] diagonal2 = new Cell[]{
                board.getCell(0, 2),
                board.getCell(1, 1),
                board.getCell(2, 0)
        };

        state = checkState(diagonal1);
        if (state != State.PLAYING) return state;
        state = checkState(diagonal2);
        return state;
    }


    private static State checkState(Cell[] cells) {


        if (Arrays.stream(cells).anyMatch(cell -> cell.getPlayer() == Player.NONE)) return State.PLAYING;
        if (Arrays.stream(cells).allMatch(cell -> cell.getPlayer() == Player.X)) return State.X_WON;
        else if (Arrays.stream(cells).allMatch(cell -> cell.getPlayer() == Player.Y)) return State.Y_WON;
        return State.PLAYING;
    }

}
