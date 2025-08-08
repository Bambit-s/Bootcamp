import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        CardPack deck = new CardPack();
        RandomHand randomHand = new RandomHand(deck.getCardPack());

        Carta[] hand = randomHand.drawFiveCards();

        System.out.println("Random hand:");
        for (Carta card : hand) {
            System.out.print(card.valorPalo() + " ");
        }

        CheckRules a = new CheckRules(hand);
        System.out.println(a.answer);
        DecimalFormat df1 = new DecimalFormat("#.#########");
        DecimalFormat df2 = new DecimalFormat("#.##########");

        double total = (52 * 51 * 50 * 49 * 48);

        double nomber1 = ((13 - 5 + 1) * 4) / total;
        String formattedNumber1 = df1.format(nomber1);
        System.out.println(formattedNumber1);

        double nomber2 = (13 * 1 * 48) / total;
        String formattedNumber2 = df2.format(nomber2);
        System.out.println(formattedNumber2);
    }
}
