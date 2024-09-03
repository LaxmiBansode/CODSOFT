// 1)generate a random number within a specified range such as 1 to 100
// 2)prompt the user to enter their guess with the generated number
// 3) compare the user's huess with the generated number and provide feedback on whether the guess is correct , too high , or too low.  
// 4) Repeat steps 2 and 3 until the user guesses the correct number 

import java.util.Random;
import java.util.Scanner;

public class NumberGuess{
    // private instance variable
    private static final int MIN_NUMBER = 1;    // Minimum number in the range
    private static final int MAX_NUMBER = 100;  // Maximum number in the range
    private static final int MAX_ATTEMPTS = 10;  // Maximum number of attempts allowed

    // entry point function
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create a scanner to read user input
        Random random = new Random();  // Create a Random object to generate random numbers
        int totalRounds = 0;  // Counter for the number of rounds played
        int totalWins = 0;    // Counter for the number of rounds won

        // Loop to allow multiple rounds of play
        while (true) {
            int numberToGuess = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;  // Generate a random number
            int attempts = 0;  // Counter for the number of attempts in the current round
            boolean hasGuessedCorrectly = false;  // Flag to check if the guess is correct

            System.out.println("\nNew Round Started!");
            System.out.println("I generated one random number you have to guess it !!! you have total 10 chance");
            System.out.println("Guess a number between " + MIN_NUMBER + " and " + MAX_NUMBER + ".");

            // Loop to handle user guesses until they guess correctly or run out of attempts
            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();  // Read the user's guess
                attempts++;  // Increment the number of attempts

                // Checking if the guess is correct, too high, or too low
                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number correctly.");
                    hasGuessedCorrectly = true;  // Set flag to true
                    break;  // Exit the loop as the user has guessed correctly
                } else if (userGuess < numberToGuess) {
                    System.out.println("Your guess is lower than the number. Try again.");
                } else {
                    System.out.println("Your guess is higher than the number. Try again.");
                }

                // showing how many try user left
                if (attempts < MAX_ATTEMPTS) {
                    System.out.println("You have only " + (MAX_ATTEMPTS - attempts) + " attempts left.");
                }
            }

            // Check if the user failed to guess the number
            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + numberToGuess + ".");
            }

            totalRounds++;  // Increment the total number of rounds played
            if (hasGuessedCorrectly) {
                totalWins++;  // Increment the total number of wins
            }

            // Prompt the user to play another round or exit
            System.out.println("\nYour score: " + totalWins + " out of " + totalRounds + " rounds.");
            System.out.print("Do you want to play again? (yes/no): ");
            scanner.nextLine();  // Consume the newline left by nextInt()
            String playAgain = scanner.nextLine();  // Read the user's choice

            // Exit the game if the user chooses not to play againues
            if (!playAgain.equalsIgnoreCase("yes")) {
                System.out.println("Thank you for playing! Your final score is: " + totalWins + " out of " + totalRounds + " rounds.");
                break;
            }
        }

        scanner.close();  // Close the scanner
    }
}


/*New Round Started!
Guess a number between 1 and 100.
Enter your guess: 25
Your guess is too low. Try again.
You have 9 attempts left.
Enter your guess: 32
Your guess is too low. Try again.
You have 8 attempts left.
Enter your guess: 80
Your guess is too high. Try again.
You have 7 attempts left.
Enter your guess: 60
Your guess is too low. Try again.
You have 6 attempts left.
Enter your guess: 77
Your guess is too high. Try again.
You have 5 attempts left.
Enter your guess: 65
Your guess is too low. Try again.
You have 4 attempts left.
Enter your guess: 70
Your guess is too low. Try again.
You have 3 attempts left.
Enter your guess: 75
Your guess is too high. Try again.
You have 2 attempts left.
Enter your guess: 72
Congratulations! You guessed the number correctly.

Your score: 1 out of 1 rounds.
Do you want to play again? (yes/no): */