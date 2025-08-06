import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Ejercicio01 {

    private static ArrayList<Integer> createArray() {
        ArrayList<Integer> mass = new ArrayList<>();
        
        for (int i = 0; i < 11; i++) {
            
            // int random_masmenus = (int) (Math.random() * 2);
            Random random = new Random();
            int new_random = random.nextInt(11)-5;
            // int random_number = (int) (Math.random() * 6);
            // int result = (random_masmenus == 0) ? (random_number * -1) : (random_number * 1);
            mass.add(new_random);
        }
        return mass;
    }

    public static void main(String[] args) {
        ArrayList<Integer> massiv = createArray();
        System.out.println(massiv);
        int biggest_number = Collections.max(massiv);
        System.out.println(biggest_number);

    }
}
