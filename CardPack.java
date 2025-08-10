import java.util.ArrayList;
import java.util.Arrays;

public class CardPack {
    String[] valores = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K" };
    String[] palos = { "S", "C", "H", "D" };

    private ArrayList<Carta> cardPack;
    Carta[] array = {};

    // constructor
    public CardPack() {
        this.cardPack = create();
    }

    // create pack cards
    public ArrayList<Carta> create() {

        ArrayList<Carta> cardPack = new ArrayList<>(Arrays.asList(this.array));

        for (String palo : palos) {
            for (String valor : valores) {
                String completo = palo + valor;
                Carta carta = new Carta(completo);
                cardPack.add(carta);
            }
        }
        return cardPack;
    }

    public Carta get(int index) {
        return cardPack.get(index);
    }

    public int lengthArray() {
        return cardPack.size();
    }

    public ArrayList<Carta> getCardPack() {
        return cardPack;
    }

    public void removeFromDeck(int index) {
        cardPack.remove(index);
    }

}
