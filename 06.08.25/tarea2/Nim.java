import java.util.Scanner;
import java.util.Random;

class Player {
    private String name;

    public Player() {
        setname(name);
    }

    public void setname(String name) {
        Scanner scanner = new Scanner(System.in);
        this.name = scanner.next();
        // scanner.close(); // trouble
    }

    public String getname() {
        return name;
    }

}

class Game {

    private String player1;
    private String player2;
    private boolean start = true;
    Random nomber = new Random();
    public int[] field = { nomber.nextInt(5) + 2, nomber.nextInt(5) + 2, nomber.nextInt(5) + 2 };

    public Game(String player1, String player2) {

        setPlayer(player1, player2);
        showNames();
        while (start) {
            showField();
            playerchoose(player1);
            if (summfield(field) <= 1) {
                System.out.println(player2 + " lose...");
                System.exit(0);
            }
            showField();
            playerchoose(player2);
            if (summfield(field) <= 1) {
                System.out.println(player1 + " lose...");
                System.exit(0);
            }
        }

    }

    public void playerchoose(String player) {
        System.out.print("\n" + player + ", choose letra:");
        Scanner scannerLetra = new Scanner(System.in);
        String chooseLetra = scannerLetra.nextLine();

        System.out.print("How much would you like to take from " + chooseLetra + ":");
        Scanner scannerNumber = new Scanner(System.in);
        int chooseNumber = scannerNumber.nextInt();

        if (chooseLetra.equals("A")) {
            field[0] = field[0] - chooseNumber;
        }
        if (chooseLetra.equals("B")) {
            field[1] = field[1] - chooseNumber;
        }
        if (chooseLetra.equals("C")) {
            field[2] = field[2] - chooseNumber;
        }
    }

    private int summfield(int[] field) {
        int sum = 0;
        for (int i = 0; i < field.length; i++) {
            sum += field[i];
        }
        return sum;
    }

    public void showField() {
        System.out.printf("A: " + field[0]);
        System.out.printf("%5s%s", "", "B: " + field[1]);
        System.out.printf("%5s%s", "", "C: " + field[2]);
    }

    public void setPlayer(String name1, String name2) {
        this.player1 = name1;
        this.player2 = name2;
    }

    public void showNames() {
        System.out.println("Player 1 is: " + player1);
        System.out.println("Player 2 is: " + player2);
    }

}

public class Nim {

    public static void main(String[] args) {
        System.out.println("Put name of 1st Player");
        Player player1 = new Player();

        System.out.println("Put name of 2st Player");
        Player player2 = new Player();

        Game game = new Game(player1.getname(), player2.getname());

    }
}