import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerRange = 1;
        int upperRange = 100;
        int maxAttempts = 10;
        int roundsPlayed = 0;
        int totalAttempts = 0;
        
        System.out.println("Welcome to Number Guessing Game!");
        
        boolean playAgain = true;
        while (playAgain) {
            int targetNumber = random.nextInt(upperRange - lowerRange + 1) + lowerRange;
            roundsPlayed++;
            int attempts = 0;
            System.out.printf("\nRound %d: Guess the number between %d and %d.%n", roundsPlayed, lowerRange, upperRange);
            
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                totalAttempts++;
                
                if (userGuess < targetNumber) {
                    System.out.println("Too low! Try a higher number.");
                } else if (userGuess > targetNumber) {
                    System.out.println("Too high! Try a lower number.");
                } else {
                    System.out.printf("Congratulations! You guessed the number %d correctly in %d attempts.%n", targetNumber, attempts);
                    break;
                }
            }
            
            if (attempts == maxAttempts) {
                System.out.printf("Sorry, you've reached the maximum number of attempts. The correct number was %d.%n", targetNumber);
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }
        
        double averageAttempts = (double) totalAttempts / roundsPlayed;
        System.out.printf("%nGame over! You played %d rounds and your average attempts per round was %.2f.%n", roundsPlayed, averageAttempts);
        
        scanner.close();
    }
}