import java.util.Scanner;

// This class handles the entire game logic using OOP principles


class GuessingGame {
    private int number;                  // The number to guess
    private int maxAttempts;             // Max attempts per round
    private int attempts;               // Total attempts made
    private boolean guessedCorrectly;
    private Scanner sc;

    // Constructor to initialize the game
    public GuessingGame(int maxAttempts) {
        this.number = 1 + (int)(100 * Math.random()); // Random number between 1 and 100
        this.maxAttempts = maxAttempts;
        this.attempts = 0;
        this.guessedCorrectly = false;
        this.sc = new Scanner(System.in);
    }

    // Display instructions before the game starts
    private void showInstructions() {
        System.out.println("A number is chosen between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts per round to guess the correct number.");
    }

    // Play a single round of guesses
    private void playRound() {
        for (int i = 0; i < maxAttempts; i++) {
            System.out.print("Enter your guess: ");
            int guess = sc.nextInt();
            attempts++;

            if (guess == number) {
                System.out.println(" Congratulations! You guessed the correct number in " + attempts + " attempts.");
                guessedCorrectly = true;
                break;
            } else if (guess < number) {
                System.out.println("The number is greater than " + guess);
            } else {
                System.out.println("The number is less than " + guess);
            }
        }
    }

    // Start the full game loop
    public void startGame() {
        showInstructions();

        while (!guessedCorrectly) {
            playRound();

            if (!guessedCorrectly) {
                System.out.println("You have used all " + maxAttempts + " attempts.");
                System.out.print("Do you want to continue guessing? (yes/no): ");
                String response = sc.next();

                if (!response.equalsIgnoreCase("yes")) {
                    System.out.println("Game Over! The correct number was: " + number);
                    break;
                }
            }
        }

        sc.close();
    }
}

// This is the main class where execution begins
public class Game2 {
    public static void main(String[] args) {
        GuessingGame game = new GuessingGame(5); 
        game.startGame();
    }
}
