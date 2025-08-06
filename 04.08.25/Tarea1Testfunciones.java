import java.util.Arrays;
import java.util.Scanner;   

public class Tarea1Testfunciones {

    private static int[] generateNumber() {
        int[] ramdomNumberArray = { 0, 0, 0, 0 };

        do {
            ramdomNumberArray = new int[] { (int) (Math.random() * 10), (int) (Math.random() * 10),
                    (int) (Math.random() * 10), (int) (Math.random() * 10) }; // create number
        } while (checkForOneNumber(ramdomNumberArray) != true); // check for one digit in number

        return ramdomNumberArray;
    }

    private static boolean checkForOneNumber(int[] ramdomNumberArray) {
        for (int i = 0; i < ramdomNumberArray.length; i++) { // found number without similars digits.
            for (int j = i + 1; j < ramdomNumberArray.length; j++) {
                if (ramdomNumberArray[i] == ramdomNumberArray[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void countTorrosVacas(int[] number_Int, int[] random_Number) {
        int torro = 0;
        int vaca = 0;

        for (int i = 0; i < random_Number.length; i++) {
            if (random_Number[i] == number_Int[i]) {
                torro += 1; // found bulls
            }
        }

        for (int i = 0; i < random_Number.length; i++) {
            for (int j = 0; j < number_Int.length; j++) {
                if (i != j && random_Number[i] == number_Int[j]) {
                    vaca += 1; // found cows
                }
            }
        }
        System.out.println(Arrays.toString(random_Number));
        System.out.println(Arrays.toString(number_Int));
        System.out.print(("Torros: " + torro));
        System.out.println((" Vacas: " + vaca));
        if (torro == 4) {
            System.out.println((" Congratulations! secret number is: " +
                    random_Number)); //
            System.exit(0);
        }

    }

    public static boolean cheackForInputNumber(String number) { // Create rools for number and digits.
        int number_Int;
        if (number.equalsIgnoreCase("exit")) { // if input exit
            System.out.println("Exit.");
            System.exit(0);
        }
        try {
            number_Int = Integer.parseInt(number);
            if (!(999 < number_Int && number_Int < 10000)) { // in range not in 1000 ... 9999 return false
                System.out.print("Bad number\n");
                return false;
            }

        } catch (NumberFormatException e) { // if got chars return false
            System.out.print("Not valid number\n");
            return false;
        }
        return true; // if got 1234 etc.
    }

    private static int[] createArray(String inputString) { // create array from string
        int number = Integer.parseInt(inputString);
        int[] inputNumber = new int[] { (number / 1000), (number / 100 % 10), (number / 10 % 10),
                (number % 10) };
        return inputNumber;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // create object for input system
        String number; // user number
        boolean success = true;
        int[] array_number; // create array fron user dataas
        int[] genNumber; // generate number random
        while (success) { // loop while true

            System.out.print("Put your int number or exit: \n"); // input from user

            if (scanner.hasNextLine()) {
                do {
                    number = scanner.nextLine(); // read from input
                } while (cheackForInputNumber(number) != true);
                {
                    genNumber = generateNumber(); // generate number random

                    array_number = createArray(number); // create array fron user dataas
                    countTorrosVacas(array_number, genNumber); // final function
                }
            }
        }
        scanner.close();
    }

}