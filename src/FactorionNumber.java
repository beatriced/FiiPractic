import java.util.Scanner;

public class FactorionNumber {

    public static final String INITIAL_MESSAGE = "Enter the numbers you want to check separated by new line. Press Ctrl + D to finish.";
    public static final String VALIDATION_MESSAGE_NOT_A_NUMBER = "Please insert a valid number.";
    public static final String VALIDATION_MESSAGE_NEGATIVE_NUMBER = "No negative numbers allowed.";
    public static final String MESSAGE_CONFIRMED_FACTORION = "The number is a factorion!";
    public static final String MESAGE_NOT_A_FACTORION = "The number is not a factorion!";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        System.out.println(INITIAL_MESSAGE);

        String userInput;
        while(scanner.hasNext()) {
            userInput = scanner.next();
            if (validateUserInput(userInput)) {
                int number = Integer.parseInt(userInput);
                System.out.println(isFactorion(number) ? MESSAGE_CONFIRMED_FACTORION : MESAGE_NOT_A_FACTORION);
            }
        }
    }

    public static boolean validateUserInput(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            System.out.println(VALIDATION_MESSAGE_NOT_A_NUMBER);
            return false;
        }

        if(Integer.parseInt(userInput) < 0) {
            System.out.println(VALIDATION_MESSAGE_NEGATIVE_NUMBER);
            return false;
        }

        return true;
    }

    public static boolean isFactorion(int number) {
        if (calculateFactorialsSum(number) == number) {
            return true;
        } else {
            return false;
        }
    }

    public static int calculateFactorialsSum(int number) {
        if (number == 0) {
            return 1;
        }

        int sumOfFactorials = 0;
        while (number != 0) {
            sumOfFactorials += computeFactorial(number % 10);
            number /= 10;
        }

        return sumOfFactorials;
    }

    public static int computeFactorial(int digit) {
        int factorial = 1;

        for (int index = 1; index <= digit; index++) {
            factorial *= index;
        }

        return factorial;
    }

}
