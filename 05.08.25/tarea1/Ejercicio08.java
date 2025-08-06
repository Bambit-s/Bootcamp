import java.util.Scanner;

public class Ejercicio08 {

    public static void main(String[] var0) {
        Scanner var2 = new Scanner(System.in);
        System.out.println("Introduzca el numero");
        if (var2.hasNextInt()) {
            int var1;
            do {
                var1 = var2.nextInt();
            } while (var1 < 0);

            System.out.println(var1);
        }

        var2.close();
    }
}
