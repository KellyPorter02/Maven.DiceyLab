import java.util.Scanner;

public class ConsoleInput {

    private static Scanner consoleIn = new Scanner(System.in);
    public static int askForNumDice() {
        System.out.println("How many dice would you like to roll?");
        return Integer.parseInt(consoleIn.nextLine());
    }

    public static int askForNumRolls() {
        System.out.println("How many times would you like to roll?");
        return Integer.parseInt(consoleIn.nextLine());
    }

}
