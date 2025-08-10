import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomHand {
    private Random random;
    public ArrayList<Carta> randomhand;
    private Carta[] array = {};

    public RandomHand() {
        this.random = new Random();
        this.randomhand = createFiveRandomCards();
        this.showFiveRandomCards();
    }

    public ArrayList<Carta> createFiveRandomCards() {
        CardPack deck = new CardPack();
        deck.create();
        int count = 0;
        ArrayList<Carta> randomhand = new ArrayList<>(Arrays.asList(this.array));
        int decklenght = deck.lengthArray();
        while (count < 5) {
            int randomCart = random.nextInt(decklenght - 1);
            deck.removeFromDeck(randomCart);
            Carta randomasd = deck.get(randomCart);
            randomhand.add(randomasd);
            count += 1;
            decklenght -= 1;
        }
        return randomhand;
    }

    private void showFiveRandomCards() {
        List<String> valores = new ArrayList<>();
        for (Carta carta : randomhand) {
            valores.add(carta.valorPalo());
        }
        System.out.println(valores);
    }

}
