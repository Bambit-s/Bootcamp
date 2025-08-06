import java.util.Scanner;

public class Ejercicio10 {

    private String[] trabajo = { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes" };
    private String[] descanso = { "Sabado", "Domingo" };

    public static void main(String[] args) {
        Ejercicio10 ejercicio = new Ejercicio10();
        Scanner scanner = new Scanner(System.in);
        String day = scanner.next();
        for (String search_day : ejercicio.descanso) {
            if (search_day.equalsIgnoreCase(day)) {
                System.out.println("Dia de descanso.");
                System.exit(0);
            }
        }
        for (String search_day : ejercicio.trabajo) {
            if (search_day.equalsIgnoreCase(day)) {
                System.out.println("Dia de trabajo.");
                System.exit(0);
            }
        }
        System.out.println("No dia!");
        scanner.close();
    }
}
