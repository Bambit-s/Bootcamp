public class CardPack {
    String[] valores = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K" };
    String[] palos = { "S", "C", "H", "D" };

    Carta[] cardPack;

    public CardPack() {
        this.cardPack = create();
    }

    private Carta[] create() {
        Carta[] result = new Carta[valores.length * palos.length];
        int index = 0;

        for (String palo : palos) {
            for (String valor : valores) {
                String completo = palo + valor;
                result[index++] = new Carta(completo);
            }
        }
        return result;
    }

    public Carta[] getCardPack() {
        return cardPack;
    }
}
