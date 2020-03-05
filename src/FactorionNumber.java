import java.util.Scanner;

public class FactorionNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Enter the numbers you want to check separated by new line. Press Ctrl + D to finish.");

        String userInput;
        while(scanner.hasNext()) {
            userInput = scanner.next();
            if (validateUserInput(userInput)) {
                int number = Integer.parseInt(userInput);
                System.out.println(isFactorion(number) ? "The number is a factorion!" : "The number is not a factorion!");
            }
        }
    }

    public static boolean validateUserInput(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            System.out.println("Please insert a valid number.");
            return false;
        }

        if(Integer.parseInt(userInput) < 0) {
            System.out.println("No negative numbers allowed.");
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
