import java.util.Random;

public class RandomHand {
    private Carta[] deck;
    private Random random;

    public RandomHand(Carta[] deck) {
        this.deck = deck;
        this.random = new Random();
    }

    public Carta[] drawFiveCards() {
        Carta[] hand = new Carta[5];
        int count = 0;

        while (count < 5) {
            Carta candidate = deck[random.nextInt(deck.length)];

            boolean exists = false;
            for (int i = 0; i < count; i++) {
                if (hand[i] != null && hand[i].valorPalo().equals(candidate.valorPalo())) {
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                hand[count++] = candidate;
            }
        }

        return hand;
    }
}
