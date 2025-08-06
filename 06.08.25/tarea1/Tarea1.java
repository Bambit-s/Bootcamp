class Reloj {
    private int horas;
    private int minutos;
    private int segundos;
    private int oneday = 86400;

    // constructor 1
    public Reloj() {
        this.horas = 12;
        this.minutos = 0;
        this.segundos = 0;
    }

    // constructor 2
    public Reloj(int horas, int minutos, int segundos) {
        setReloj(horas * 60 * 60 + minutos * 60 + segundos);
    }

    // constructor 3
    public Reloj(int segundos) {
        setReloj(segundos);
    }

    // tiempo desde medianoche
    public void setReloj(int segundos) {

        segundos = segundos % oneday;

        if (segundos < 0) {
            segundos += oneday;
        }

        int horas = segundos / 3600;
        int resto = segundos % 3600;
        int minutos = resto / 60;
        int segundosRestantes = resto % 60;

        setHoras(horas);
        setMinutos(minutos);
        setSegundos(segundosRestantes);
    }

    // return Horas
    private int getHoras() {
        return horas;
    }

    // return Minutos
    private int getMinutos() {
        return minutos;
    }

    // return Segundos
    private int getSegundos() {
        return segundos;
    }

    // Setean Horas
    private void setHoras(int input) {
        this.horas = input;
    }

    // Setean Minutos
    private void setMinutos(int input) {
        this.minutos = input;
    }

    // Setean Segundos
    private void setSegundos(int input) {
        this.segundos = input;
    }

    // incrementar el tiempo de lossegundos en 1
    public void tick() {
        int total = getHoras() * 60 * 60 + getMinutos() * 60 + getSegundos() + 1;
        setReloj(total);
    }

    public void tickDecrement() {
        int total = getHoras() * 60 * 60 + getMinutos() * 60 + getSegundos() - 1;
        setReloj(total);
    }

    // representando el objeto Reloj en el formato "[hh:mm:ss]",
    // por ejemplo "[22:32:12]"
    public String toString() {
        return "[" + String.format("%02d", getHoras()) + ":" + String.format("%02d", getMinutos()) + ":"
                + String.format("%02d", getSegundos())
                + "]";
    }

    // sum
    public void addReloj(Reloj otrorReloj) {
        int firsttime = getHoras() * 60 * 60 + getMinutos() * 60 + getSegundos();
        int alltime = firsttime + otrorReloj.getHoras() * 60 * 60 + otrorReloj.getMinutos() * 60
                + otrorReloj.getSegundos();
        alltime = alltime % oneday;
        setReloj(alltime);
    }

    public void restaReloj(Reloj otrorReloj) {
        int firsttime = getHoras() * 60 * 60 + getMinutos() * 60 + getSegundos();
        int secondtime = otrorReloj.getHoras() * 60 * 60 + otrorReloj.getMinutos() * 60
                + otrorReloj.getSegundos();
        int differnce = (firsttime - secondtime + oneday) % oneday;
        setReloj(differnce);
    }

}

public class Tarea1 {
    public static void main(String[] args) {
        Reloj reloj2 = new Reloj(0, 0, 10);
        Reloj reloj1 = new Reloj(0, 2, 3);
        reloj2.restaReloj(reloj1);
        System.out.println(reloj2.toString());

    }
}
