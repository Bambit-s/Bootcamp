import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio04 {
    public static ArrayList<Character> arraynumbers(String input) {
        ArrayList<Character> mass = new ArrayList<Character>(); //123
        String[] number= new String[4];
        for (int i = 0; i < input.length(); i++) {
            char sim1 = input.charAt(i);
            mass.add(sim1);
        }
        return mass;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(arraynumbers(input));
        scanner.close();
    }
}
