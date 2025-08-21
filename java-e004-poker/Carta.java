public class Carta {
    private String valor;
    private String palo;

    public Carta() {

    }

    public Carta(String str) {
        this.palo = String.valueOf(str.charAt(0));
        this.valor = String.valueOf(str.charAt(1));
    }

    public String valorPalo() {
        return this.valor + this.palo;
    }
}
