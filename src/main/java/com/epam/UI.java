package com.epam;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class UI {
    private final Scanner in;
    private final PrintStream out;

    public UI(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }

    public int getCellNumber(Player player) {
        showMessage("It's your turn Mr." + player + ". Please choose number of cell between 1 and 9: \n");

        return in.nextInt();
    }

    private Cell getCell(int position, Board board) {
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

    public String intro() {
        return "Welcome to Tic-tac-toe game.\n" +
                "Please choose cell number as follow: \n\n" +
                " 7 | 8 | 9\n" +
                "---|---|---\n" +
                " 4 | 5 | 6\n" +
                "---|---|---\n" +
                " 1 | 2 | 3\n";
    }

    public void showMessage(String message) {
        out.println(message);
    }

}
