import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minGuess = 1;
        int maxGuess = 100;
        int maxAttemptsPerRound = 5;

        boolean playAgain = true;
        while (playAgain) {
            int totalAttempts = 0;

            System.out.print("How many rounds do you want to play? ");
            int rounds = scanner.nextInt();

            for (int i = 1; i <= rounds; i++) {
                System.out.println("\nRound " + i + ":");
                int attempts = playRound(scanner, random, minGuess, maxGuess, maxAttemptsPerRound);
                totalAttempts += attempts;
            }

            double averageAttempts = (double) totalAttempts / rounds;
            System.out.println("\nGame over! Your average number of attempts per round was: " + averageAttempts);

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");

            if (!playAgain) {
                System.out.println("Exiting the game. Thank you for playing!");
            }
        }

        scanner.close();
    }

    public static int playRound(Scanner scanner, Random random, int minGuess, int maxGuess, int maxAttemptsPerRound) {
        int secretNumber = random.nextInt(maxGuess - minGuess + 1) + minGuess;
        int attempts = 0;

        while (attempts < maxAttemptsPerRound) {
            System.out.print("Guess the number (between " + minGuess + " and " + maxGuess + "): ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess < minGuess || guess > maxGuess) {
                System.out.println("Your guess is outside the valid range. Please try again.");
            } else if (guess < secretNumber) {
                System.out.println("Too low, try again.");
            } else if (guess > secretNumber) {
                System.out.println("Too high, try again.");
            } else {
                System.out.println("Congratulations! You guessed the number " + secretNumber + " in " + attempts + " attempts.");
                return attempts;
            }
        }

        System.out.println("Sorry, you've reached the maximum number of attempts for this round.");
        return attempts;
    }
}
