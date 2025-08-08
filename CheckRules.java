public class CheckRules {
    private Carta[] fivevalues;
    public String answer;
    private int countColor;
    private int countPocker;
    private int countEscaleraColor;
    private int countEscalera;
    private int countFull;
    public String highest_card_String = "";

    public CheckRules(Carta[] fivecards) {
        this.fivevalues = fivecards;
        this.answer = check(fivevalues);
    }

    private int ChooseVolor(String match_Valor) {

        if (match_Valor.equals("T")) {
            return 10;
        } else if (match_Valor.equals("J")) {
            return 11;
        } else if (match_Valor.equals("Q")) {
            return 12;
        } else if (match_Valor.equals("K")) {
            return 13;
        } else if (match_Valor.equals("A")) {
            return 14;
        } else {
            return Integer.valueOf(match_Valor);
        }
    }

    private String check(Carta[] pack) {
        countColor = 0;
        countPocker = 0;
        countEscaleraColor = 0;
        countEscalera = 0;
        countFull = 0;
        int match_uno_Valor_int;
        int match_dos_Valor_int;
        int highest_card = 0;
        for (Carta carta_uno : pack) { 
            String match_uno = carta_uno.valorPalo();
            int index_uno = 0;
            String match_uno_Valor = match_uno.substring(0, 1);
            match_uno_Valor_int = ChooseVolor(match_uno_Valor);

            String match_uno_Calor = match_uno.substring(1, 2);

            // for biggest card
            if (match_uno_Valor_int > highest_card) {
                highest_card = match_uno_Valor_int;
                highest_card_String = match_uno;
            }
            
            for (Carta carta_dos : pack) {
                String match_dos = carta_dos.valorPalo();
                int index_two = 0;
                String match_dos_Valor = match_dos.substring(0, 1);

                match_dos_Valor_int = ChooseVolor(match_dos_Valor);

                String match_dos_Calor = match_dos.substring(1, 2);

                

                if (!(match_uno_Calor.equals(match_dos_Calor)) && (index_uno + 1 == index_two)) {
                    countEscaleraColor += 1;
                }
                if ((match_uno_Valor_int + 1 == match_dos_Valor_int) && (index_uno + 1 == index_two)) {
                    countEscalera += 1;
                }
                if (match_uno_Calor.equals(match_dos_Calor)) {
                    countColor += 1;
                }
                if (match_uno_Valor_int == match_dos_Valor_int) {
                    countFull += 1;
                }
                if (match_uno_Valor_int == match_dos_Valor_int) {
                    countPocker += 1;
                }
                index_two++;
            }
            index_uno++;
        }

        if (countEscaleraColor == 4) {
            return "\nEscalera Color!";
        }
        if (countEscalera == 4) {
            return "\nEscalera";
        }
        if (countColor == 25) {
            return "\nFive cards with the same COLOR";
        }
        if (countFull == 13) {
            return "\n3 and 2 cards with the nombers ";
        }
        if (countFull == 11) {
            return "\n3 cards with the nombers ";
        }
        if (countFull == 9) {
            return "\n2 cards with 2 paras with the nombers ";
        }
        if (countFull == 7) {
            return "\n2 cards with 1 para with the nombers ";
        }
        if (countPocker == 17) {
            return "\n4 cards create Poker";
        }
        return "\nhighest is :" + highest_card_String;
    }

}