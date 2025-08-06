import java.util.Scanner;

public class Ejercicio09 {
    public static void main(String[] args) {
        String password = "1234";
        String password_input;
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        if (scanner.hasNext()) {
            do {
                password_input = scanner.next();
                count += 1;

                if (password_input.equals(password)) {
                    System.out.println("Correcto!");
                    System.exit(0);
                }
                if (count == 3) {
                    System.out.println("Fallaste jaja!!");
                    System.exit(0);
                }
            } while (true);
        }
        scanner.close();
    }
}
