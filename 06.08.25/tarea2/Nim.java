import java.util.Scanner;
import java.util.Random;

class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

class Game {
    private Scanner scaner;
    private String player1;
    private String player2;
    private int[] field;
    private boolean start = true;
    Random nomber = new Random();

    public Game(String player1, String player2, Scanner scaner) {
        this.player1 = player1;
        this.player2 = player2;
        this.scaner = scaner;
        field = new int[] { nomber.nextInt(5) + 2, nomber.nextInt(5) + 2, nomber.nextInt(5) + 2 };

        play();
    }

    private void play() {
        showNames();
        while (start) {
            showField();
            if (playerChoose(player1)) {
                System.out.println(player1 + " lose...");
                break;
            }
            showField();
            if (playerChoose(player2)) {
                System.out.println(player2 + " lose...");
                break;
            }
        }
    }

    public boolean playerChoose(String player) {
        System.out.print("\n" + player + ", choose letra(A, B or C):");
        int index = -1;
        while (index == -1) {
            String choice = scaner.nextLine().trim().toUpperCase();
            if (choice.equals("A"))
                index = 0;
            else if (choice.equals("B"))
                index = 1;
            else if (choice.equals("C"))
                index = 2;
            else
                System.out.println("Invalid letra!");
        }

        System.out.print("How much would you like to take from " + (char) (index + 'A') + ":");
        int number = -1;
        while (number <= 0 || number > field[index]) {
            try {
                number = Integer.parseInt(scaner.nextLine());
                if (number <= 0 || number > field[index]) {
                    System.out.println("Invalid number. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number.");
            }
        }
        field[index] -= number;
        return totalCounters() == 0;
    }

    private int totalCounters() {
        return field[0] + field[1] + field[2];
    }

    public void showField() {
        System.out.println("\nCurrent field:");
        System.out.println("A: " + field[0] + "\tB: " + field[1] + "\tC: " + field[2]);
    }

    public void showNames() {
        System.out.println("Player 1 is: " + player1);
        System.out.println("Player 2 is: " + player2);
    }

}

public class Nim {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Put name of 1st Player");
        Player player1 = new Player(scanner.nextLine());

        System.out.println("Put name of 2st Player");
        Player player2 = new Player(scanner.nextLine());

        Game game = new Game(player1.getName(), player2.getName(), scanner);

    }
}