import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.text.DecimalFormat;

public class Generala {
    private String[] arrayDados;
    private boolean isNumeric;
    private int count;
    private int countEscalera;
    private int lengthStr;

    // ESTA ES LA FUNCIÓN QUE HAY QUE IMPLEMENTAR
    // TAMBIÉN PUEDEN AGREGAR OTRAS FUNCIONES y/o CLASES
    // QUE NECESITEN PARA RESOLVER EL EJERCICIO DE LA
    // MANERA MÁS ORDENADA POSIBLE
    private boolean validationCheck(String dados) {
        lengthStr = dados.length();
        isNumeric = dados.matches("\\d+");
        if (!isNumeric || lengthStr != 5) {
            return false;
        }
        return true;
    }

    private int solution(String dados) {
        arrayDados = dados.split("");
        count = 0;
        countEscalera = 0;
        for (int i = 0; i < arrayDados.length; i++) {
            String oneNumber = arrayDados[i];
            Integer oneNumberInt = Integer.valueOf(oneNumber);
            if (i != 4) {
                String secondNumber = arrayDados[i + 1];
                Integer secondNumberInt = Integer.valueOf(secondNumber);
                if (oneNumberInt + 1 == secondNumberInt) {
                    countEscalera += 1;
                }
            }
            for (int j = 0; j < arrayDados.length; j++) {
                if (arrayDados[j].equals(arrayDados[i])) {
                    count += 1;
                }
            }
        }
        if (countEscalera == 4) {
            count = countEscalera;
        }
        return count;
    }

    private String response(int count) {
        if (count == 4) {
            return "ESCALERA";
        } else if (count == 25) {
            return "GENERALA";
        }
        if (count == 17) {
            return "POKER";
        }
        if (count == 13 || count == 16) {
            return "FULL";
        }

        return "NADA";
    }

    String jugada(String dados) {
        // check for validation.
        if (!validationCheck(dados)) {
            return "INVALIDO";
        }
        //
        solution(dados);

        return response(count);

    }

    // Ustedes pueden ignorar esto
    String[] jugadas(String[] losdados) {
        String[] ret = new String[losdados.length];
        int i = 0;
        for (String dados : losdados) {
            ret[i] = this.jugada(dados);
            i++;
        }
        return ret;
    }

    // Ustedes pueden ignorar esto
    static String[] processBatch(String fileName)
            throws Exception {
        Scanner sc = new Scanner(new File(fileName));
        List<String> lines = new ArrayList<String>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }
        return lines.toArray(new String[0]);
    }

    public static void main(String[] args)
            throws Exception {
        Generala g = new Generala();

        /* IGNORAR PORQUE ESTO NO SE VA A EJECUTAR PARA USTEDES */
        if (args.length > 0) {
            String[] jugadas = processBatch(args[0]);
            String resultados[] = g.jugadas(jugadas);
            for (String res : resultados) {
                System.out.println(res);
            }
            return;
        }
        // ESTO SI SE EJECUTA PARA USTEDES
        System.out.println(g.jugada("11111")); // GENERALA
        System.out.println(g.jugada("66666")); // GENERALA
        System.out.println(g.jugada("11112")); // POKER
        System.out.println(g.jugada("55554")); // POKER
        System.out.println(g.jugada("33322")); // FULL
        System.out.println(g.jugada("44411")); // FULL
        System.out.println(g.jugada("12345")); // ESCALERA
        System.out.println(g.jugada("23456")); // ESCALERA
        System.out.println(g.jugada("34567")); // ESCALERA
        System.out.println(g.jugada("12346")); // NADA
        System.out.println(g.jugada("12456")); // NADA
        System.out.println(g.jugada("12556")); // NADA
        // Chance to win

        for (int i = 6; i < 10; i++) {
            double a = Math.pow(i, 5);
            float f = (float) a;
            f = i / f;
            DecimalFormat df = new DecimalFormat("#.#######"); 
            String formattedNumber = df.format(f);
            System.out.println("chance to win GENERALA with 1 to " + i + " chars in one number " + formattedNumber);
        }
                // Chance to win
            System.out.println("______"); 
        
        for (int i = 6; i < 10; i++) {
            double a = Math.pow(i, 5);
            float f = (float) a;
            f = (4*i*5) / f;
            DecimalFormat df = new DecimalFormat("#.#####"); 
            String formattedNumber = df.format(f);
            System.out.println("chance to win CARE/POKER with 1 to " + i + " chars in one number " + formattedNumber);
        }

        // System.out.print("\033[2J");

    }

}