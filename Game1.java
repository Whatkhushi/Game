import java.util.Scanner;

class NumberGuessingGame {
    private int number;
    private int maxAttempts;
    private Scanner scanner;

   
    public NumberGuessingGame(int maxAttempts) {
        this.maxAttempts = maxAttempts;
        this.number = 1 + (int)(100 * Math.random());
        this.scanner = new Scanner(System.in);
    }

    // Method to start the game
    public void play() {
        System.out.println("A number is chosen between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts to guess the correct number.");

        for (int i = 0; i < maxAttempts; i++) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();

            if (guess == number) {
                System.out.println("Congratulations! You guessed the correct number.");
                return;
            } else if (guess < number) {
                System.out.println("The number is greater than " + guess);
            } else {
                System.out.println("The number is less than " + guess);
            }
        }

        System.out.println("You've exhausted all attempts. The correct number was: " + number);
    }

    // Method to clean up resources
    public void closeScanner() {
        scanner.close();
    }
}

   // Rename this class to match the filename `Game1.java`
    public class Game1 {
    public static void main(String[] args) {
        NumberGuessingGame game = new NumberGuessingGame(5);
        game.play();
        game.closeScanner();
    }
}
