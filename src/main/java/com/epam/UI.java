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


}
