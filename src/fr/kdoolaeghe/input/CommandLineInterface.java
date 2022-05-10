package fr.kdoolaeghe.input;

import java.util.Scanner;

public class CommandLineInterface {

    private final Scanner scanner;

    public CommandLineInterface() {
        scanner = new Scanner(System.in);
    }

    public String scanCommand() {
        return scanner.nextLine();
    }
}
