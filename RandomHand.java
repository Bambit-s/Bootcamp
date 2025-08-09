import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomHand {
    private Random random;
    private ArrayList<Carta> randomhand;
    private Carta[] array = {};

    public RandomHand() {
        this.random = new Random();
        this.randomhand = createFiveRandomCards();
    }

    private ArrayList<Carta> createFiveRandomCards() {
        CardPack deck = new CardPack();
        deck.create();
        int count = 0;
        ArrayList<Carta> randomhand = new ArrayList<>(Arrays.asList(this.array));
        while (count < 5) {
            int randomCart = random.nextInt(deck.lengthArray());
            deck.removeFromDeck(randomCart);
            Carta randomasd = deck.get(randomCart);
            randomhand.add(randomasd);
            count += 1;

            // System.out.println(randomasd.valorPalo());
            // System.out.println(deck.get(randomCart));
            // System.out.println(randomhand);
        }
        return randomhand;
    }

    public void showFiveRandomCards() {
        List<String> valores = new ArrayList<>();
        for (Carta carta : randomhand) {
            valores.add(carta.valorPalo());
        }
        System.out.println(valores);
    }

}
