import java.util.Scanner;

public class Ejercicio06 {

    public static void main(String[] args) {
        float iva = 1.1f;
        System.out.println("Sintroduzca el precio sin IVA.");
        Scanner scanner = new Scanner(System.in);
        float numero = scanner.nextFloat();
        float total = numero * iva;
        System.out.println("El precio con IVA: " + total);
        scanner.close();
    }
}