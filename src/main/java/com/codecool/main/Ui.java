package com.codecool.main;

import java.util.Scanner;

public class Ui {

    private Scanner scanner;

    public String getInput() {
        scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }
}
