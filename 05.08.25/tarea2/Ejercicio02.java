import java.util.ArrayList;

public class Ejercicio02 {

    private static ArrayList<Integer> createArray() {
        ArrayList<Integer> mass = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            int random_masmenus = (int) (Math.random() * 2);
            int random_number = (int) (Math.random() * 31);
            int result = (random_masmenus == 0) ? (random_number * -1) : (random_number * 1);
            mass.add(result);
        }
        return mass;
    }

    private static int mustpopular(ArrayList<Integer> mass) {
        int maxCount = 0; //10
        int popular_number = 0; //-18
        int size = mass.size();
        for (int i = 0; i < size; i++) {
            int count = 0;
            for (int j = 0; j < size; j++) {
                if (mass.get(i).equals(mass.get(j))) {
                    count += 1;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                popular_number = mass.get(i);
            }
        }
        return popular_number;
    }

    private static ArrayList<Integer> foundallnumbers(ArrayList<Integer> mass) {
        ArrayList<Integer> foundall = new ArrayList<Integer>();
        for (int i = -30; i < 31; i++) {
            if (!mass.contains(i)) {
                foundall.add(i);
            }

        }
        return foundall;
    }

    public static void main(String[] args) {
        ArrayList<Integer> massiv = createArray();
        System.out.println(massiv);
        System.out.println(mustpopular(massiv));
        System.out.println(foundallnumbers(massiv));
    }
}
