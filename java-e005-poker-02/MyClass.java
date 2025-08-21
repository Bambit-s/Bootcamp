import java.util.*;

public class MyClass {

    private static Map<String, Integer> dict = new HashMap<>();

    public static String ganadores(ArrayList<ArrayList<Carta>> jugadas) {

        dict.put("Escalera Color.", 0);
        dict.put("Escalera.", 1);
        dict.put("Color.", 2);
        dict.put("Poker.", 3);
        dict.put("Full.", 4);
        dict.put("Trio.", 5);
        dict.put("Par doble.", 6);
        dict.put("Par.", 7);
        dict.put("Carta Alta.", 9);

        String result = "";
        System.out.println("Cantidad de jugadas: " + jugadas.size());
        Integer key = 10;
        for (ArrayList<Carta> mano : jugadas) {

            CheckRules game = new CheckRules(mano);

            game.showAnswer();

            String ans = game.answer;
            if (dict.get(ans) < key) {
                key = dict.get(ans);
                result = game.answer;
            }
            System.out.println("JUGADA ======================");
            for (Carta c : mano) {
                System.out.println(c.valorPalo());
            }
        }
        return result;
    }

    public static void main(String args[]) {

        ArrayList<ArrayList<Carta>> packcards = new ArrayList<ArrayList<Carta>>();

        Carta[] array = {};
        ArrayList<Carta> hand = new ArrayList<>(Arrays.asList(array));
        hand.add(new Carta("2S"));
        hand.add(new Carta("3S"));
        hand.add(new Carta("4S"));
        hand.add(new Carta("5S"));
        hand.add(new Carta("6S"));

        ArrayList<Carta> hand1 = new ArrayList<>(Arrays.asList(array));
        hand1.add(new Carta("AS"));
        hand1.add(new Carta("3S"));
        hand1.add(new Carta("4S"));
        hand1.add(new Carta("5S"));
        hand1.add(new Carta("AS"));

        packcards.add(hand);
        packcards.add(hand1);

        System.out.println(ganadores(packcards));
    }
}