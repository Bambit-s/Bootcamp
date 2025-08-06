import java.util.Scanner;

public class RelojDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the number of seconds '1000'.");
        String input = scanner.nextLine();
        int intinput = Integer.parseInt(input);
        Reloj reloj = new Reloj(intinput);
        for (int i = 0; i < 10; i++) {
            reloj.tick();
            System.out.println(reloj.toString());
        }
        Reloj reloj1 = new Reloj(123);
        reloj.restaReloj(reloj1);
        System.out.println(reloj.toString());
        scanner.close();
    }
}