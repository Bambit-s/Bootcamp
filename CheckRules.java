import java.util.ArrayList;
// import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CheckRules {
    private Map<String, Integer> palosCount = new HashMap<>();
    private Map<String, Integer> valoresCount = new HashMap<>();
    private ArrayList<Integer> valoresInt = new ArrayList<>();
    private String highestCard = "";
    private ArrayList<Carta> fivevalues;
    public String answer;
    Map<String, Integer> dict = new HashMap<>() {
        {
            put("2", 2);
            put("3", 3);
            put("4", 4);
            put("5", 5);
            put("6", 6);
            put("7", 7);
            put("8", 8);
            put("9", 9);
            put("T", 10);
            put("J", 11);
            put("Q", 12);
            put("K", 13);
            put("A", 14);
        }
    };

    public CheckRules(ArrayList<Carta> fivecards) {
        this.fivevalues = fivecards;
    }

    public void showAnswer() {
        this.answer = check(fivevalues);
        // System.out.println(this.answer);
    }

    private String check(ArrayList<Carta> pack) {
        int highestValue = 0;

        for (Carta cart : pack) {
            String cardone = cart.valorPalo();
            String valor = cardone.substring(0, 1); //
            String palo = cardone.substring(1, 2);

            palosCount.put(palo, palosCount.getOrDefault(palo, 0) + 1); //
            valoresCount.put(valor, valoresCount.getOrDefault(valor, 0) + 1); //

            int valueInt = dict.get(valor);
            valoresInt.add(dict.get(valor));
            if (valueInt > highestValue) {
                highestValue = valueInt;
                highestCard = cardone;
            }
        }
        return escaleraAndColor();

    }

    private String escaleraAndColor() {
        if (valoresInt.get(0) == 14 && valoresInt.get(1) == 2 && valoresInt.get(2) == 3 && valoresInt.get(3) == 4   //A...4
                && valoresInt.get(4) == 5) {
            valoresInt.set(0, 1);
            if (palosCount.containsValue(5)) {
                return "Escalera Color.";
            }
            return "Escalera.";
        }
        if (valoresInt.get(0) == 10 && valoresInt.get(1) == 11 && valoresInt.get(2) == 12 // 10...14
                && valoresInt.get(3) == 13 && valoresInt.get(4) == 14) {
            if (palosCount.containsValue(5)) {
                return "Escalera Color.";
            }
            return "Escalera.";
        }
        int c = 0;
        for (int i = 0; i < valoresInt.size() - 1; i++) {
            if ((valoresInt.get(i) - valoresInt.get(i + 1)) == -1) {
                c += 1;
            }
        }

        if (c == 4) {
            if (palosCount.containsValue(5)) {
                return "Escalera Color.";    //2s..6s
            }
            return "Escalera.";  //2s..6d
        }

        if (palosCount.containsValue(5))
            return "Color.";
        if (valoresCount.containsValue(4))
            return "Poker.";
        if (valoresCount.containsValue(3) && valoresCount.containsValue(2)) //
            return "Full.";
        if (valoresCount.containsValue(3))
            return "Trio.";
        if (Collections.frequency(valoresCount.values(), 2) == 2)
            return "Par doble.";
        if (valoresCount.containsValue(2))
            return "Par.";
        return "Carta Alta ";
    }

}