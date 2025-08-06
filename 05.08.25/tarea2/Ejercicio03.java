import java.util.Scanner;

class Checkforsimbols {
    String string1;

    public checkforsimbols(String firstWord){
        this.string1=firstWord;
    }
    
}

public class Ejercicio03 {
    public static String checkforsimbols(String input) { // as 123 sa
        String new_input = input.replaceAll("[^a-zA-Z]", ""); // regular expression
        return new_input; // assa
    }

    public static Boolean ispalindrome(String new_input) {
        int len = new_input.length();
        if (len == 1) {
            return true;
        }

        if (len % 2 == 0) {
            String mas1 = new_input.substring(0, len / 2); // as
            String mas2 = new_input.substring(len / 2, len); // sa
            String mas2reserved = new StringBuilder(mas2).reverse().toString(); // as
            for (int i = 0; i < (len / 2); i++) {
                char sim1 = mas1.charAt(i);
                char sim2 = mas2reserved.charAt(i);
                if (!(sim1 == sim2)) {
                    return false;
                }
            }
        }
        if (len % 2 == 1) {
            String mas1 = new_input.substring(0, len / 2);
            String mas2 = new_input.substring(len / 2 + 1, len);
            String mas2reserved = new StringBuilder(mas2).reverse().toString();
            // System.out.println(mas1);
            // System.out.println(mas2reserved);
            for (int i = 0; i < (len / 2); i++) {
                char sim1 = mas1.charAt(i);
                char sim2 = mas2reserved.charAt(i);
                if (!(sim1 == sim2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine(); // next() made a cut after the 1st space
        String new_word = checkforsimbols(input);
        if (ispalindrome(new_word)) {
            System.out.println("This is Palindrom");
        } else {
            System.out.println("This is NOT Palindrom");
        }

        scanner.close();

        Checkforsimbols check = new Checkforsimbols("hello");
        check.ispalindrome()
        return check.toString();
    }
}
