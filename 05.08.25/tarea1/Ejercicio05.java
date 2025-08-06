import java.util.Scanner;

public class Ejercicio05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca un número entero: ");
        int digit = scanner.nextInt();
        String result = (digit % 2 == 0) ? "se divide en 2" : "no se divide en 2";
        System.out.println(result);
        scanner.close();
    }
}
