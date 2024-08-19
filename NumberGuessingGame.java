import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int score = 0;
        int minRange = 1;
        int maxRange = 100;
        int randomNumber = rand.nextInt(maxRange - minRange + 1) + minRange;
        int maximumNumberOfAttempts = 10;

        System.out.println("Hello, Welcome to The Number Guessing Game!");
        System.out.println("I'm thinking of a number between " + minRange + " and " + maxRange + ".");
        System.out.println("You will have " + maximumNumberOfAttempts + " attempts to guess it.");

        for (int attempts = 1; attempts <= maximumNumberOfAttempts; attempts++) {
            System.out.print("Attempt " + attempts + ": Enter your guess: ");
            int userGuess = sc.nextInt();

            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the correct number " + randomNumber + " in " + attempts + " attempts.");
                score = maximumNumberOfAttempts - attempts + 1;
                break;
            } else if (userGuess < randomNumber) {
                System.out.println("Your guess is too low. Try again.");
            } else {
                System.out.println("Your guess is too high. Try again.");
            }
        }

        if (score > 0) {
            System.out.println("Your score: " + score);
        } else {
            System.out.println("Sorry, you were not able to guess the number. The correct number was " + randomNumber + ".");
        }

        sc.close();  // Close the scanner to avoid resource leak
    }
}











