package fr.kdoolaeghe.input;

public class NumberInput {

    private CommandLineInterface cli;

    public NumberInput() {
        cli = new CommandLineInterface();
    }

    public double promptNumber(String message) {
        try {
            System.out.print(message);
            return Double.parseDouble(cli.scanCommand());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return promptNumber(message);
        }
    }
}
