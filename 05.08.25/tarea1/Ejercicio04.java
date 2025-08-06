import java.util.Scanner;

public class Ejercicio04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tu nombre es ...");
        String name = scanner.nextLine();
        System.out.println("Bienvenido " + name);
        scanner.close();
    }
}
