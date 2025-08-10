public class Main {
    public static void main(String[] args) {

        RandomHand randomHand = new RandomHand();

        CheckRules game = new CheckRules(randomHand.randomhand);
        game.showAnswer();

        // DecimalFormat df1 = new DecimalFormat("#.#########");
        // DecimalFormat df2 = new DecimalFormat("#.##########");

        // double total = (52 * 51 * 50 * 49 * 48);

        // double nomber1 = ((13 - 5 + 1) * 4) / total;
        // String formattedNumber1 = df1.format(nomber1);
        // System.out.println(formattedNumber1);

        // double nomber2 = (13 * 1 * 48) / total;
        // String formattedNumber2 = df2.format(nomber2);
        // System.out.println(formattedNumber2);
    }
}
