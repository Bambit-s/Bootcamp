import java.util.Arrays;
import java.util.Scanner;

public class Tarea1 {

    private static void generate(int number_Int) {

        int randomNumber = 999;
        int[] ramdomNumberArray = new int[] { 0, 0, 0, 0 };
        while ((randomNumber < 1000)) {
            randomNumber = (int) (Math.random() * 10001); // Generate number random number is 1234 etc.
            if (randomNumber > 1000) {
                ramdomNumberArray = new int[] { randomNumber / 1000, randomNumber / 100 % 10, randomNumber / 10 % 10,
                        randomNumber % 10 }; // Create array with numbers [1,2,3,4] etc.
                for (int i = 0; i < ramdomNumberArray.length; i++) { // found number without similars numbers.
                    for (int j = i + 1; j < ramdomNumberArray.length; j++) {
                        if (ramdomNumberArray[i] == ramdomNumberArray[j]) {
                            randomNumber = 999;
                        }
                    }
                }
            }
        }

        System.out.println(Arrays.toString(ramdomNumberArray));

        int[] inputNumber = new int[] { (number_Int / 1000), (number_Int / 100 % 10), (number_Int / 10 % 10),
                (number_Int % 10) }; // create array for input user number [4,3,2,1] etc.

        System.out.println(Arrays.toString(inputNumber));
        int torro = 0;
        int vaca = 0;

        for (int i = 0; i < ramdomNumberArray.length; i++) {
            if (ramdomNumberArray[i] == inputNumber[i]) { // found bulls
                torro += 1;
            }
        }

        for (int i = 0; i < ramdomNumberArray.length; i++) {
            for (int j = 0; j < inputNumber.length; j++) {
                if (i != j && ramdomNumberArray[i] == inputNumber[j]) {
                    vaca += 1; // found cows
                }
            }
        }
        System.out.print(("Torros:  " + torro));
        System.out.println((" Vacas: " + vaca));
        if (torro == 4) {
            System.out.println((" Congratulations! secret number is: " + randomNumber));
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // create object for input system
        String number; // integer in str from user
        int number_Int;
        boolean success = true;
        while (success) { // loop while true

            System.out.print("Put your int number or exit: \n"); // input from user

            if (scanner.hasNextLine()) {   
                number = scanner.nextLine();    //read from input

                if (number.equalsIgnoreCase("exit")) {
                    System.out.println("Exit.");
                    break;
                }
                try {
                    number_Int = Integer.parseInt(number);
                    if (!(999 < number_Int && number_Int < 10000)) {
                        System.out.print("Bad number\n");
                    } else {
                        generate(number_Int);
                    }

                } catch (NumberFormatException e) {
                    System.out.print("Not valid number\n");
                }

            }
        }
        scanner.close();
    }

}