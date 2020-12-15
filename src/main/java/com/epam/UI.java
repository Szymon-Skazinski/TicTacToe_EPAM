package com.epam;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UI {
    private final Scanner in;
    private final PrintStream out;

    public UI(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }

    public int getCellNumber() {
        return in.nextInt();
    }

    public Cell getCellByPosition(int position, Board board) {
        Cell cell;

        switch (position) {

            case 1:
                cell = board.getCell(2, 0);
                break;
            case 2:
                cell = board.getCell(2, 1);
                break;
            case 3:
                cell = board.getCell(2, 2);
                break;

            case 4:
                cell = board.getCell(1, 0);
                break;
            case 5:
                cell = board.getCell(1, 1);
                break;
            case 6:
                cell = board.getCell(1, 2);
                break;

            case 7:
                cell = board.getCell(0, 0);
                break;
            case 8:
                cell = board.getCell(0, 1);
                break;
            case 9:
                cell = board.getCell(0, 2);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }
        return cell;
    }

    public void intro() {
        showMessage("Welcome to Tic-tac-toe game.\n" +
                "Please choose cell number as follow: \n\n" +
                " 7 | 8 | 9\n" +
                "---|---|---\n" +
                " 4 | 5 | 6\n" +
                "---|---|---\n" +
                " 1 | 2 | 3\n");
    }

    public void printBoard(Board board) {
        Cell[][] cellsArray = board.getBoard();
        for (int i = 0; i < cellsArray.length; i++) {
            Cell[] cells = cellsArray[i];
            String row = Arrays.stream(cells)
                    .map(c -> c.getPlayer().toString())
                    .collect(Collectors.joining(" | ", " ", " \n"));

            showMessage(row);
            if (i != cellsArray.length - 1) {
                showMessage("---|---|---\n");
            }
        }
    }

    public void showMessage(String message) {
        out.print(message);
    }


}
