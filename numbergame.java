import java.util.Random;
import java.util.Scanner;

public class numbergame {

    public static void main(String[] args){
        playGame();
    }
    
    private static void playGame(){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound= 1;
        int upperBound= 100;
        int maxAttempts= 10;
        int totalRoundsWon= 0;

        while (true){
            int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int totalAttempts = 0;

            System.out.println("guess the number between " + lowerBound + " and " + upperBound + ": ");

            while (true){
                int userGuess = scanner.nextInt();

                if (userGuess == secretNumber){
                    System.out.println("Congratulations! you guessed the correct number in " + (totalAttempts + 1) + " attempts.");
                    totalRoundsWon++;
                    break;
                }
                else if (userGuess < secretNumber){
                    System.out.println("Too low! Try again.");
                }
                else {
                    System.out.println("Too high! try again.");
                }

                totalAttempts++;

                if (totalAttempts >= maxAttempts){
                    System.out.println("Sorry, you've reached the maximum number of attempts.The correct number was" + secretNumber + ".");
                    break;
                }
            }
            System.out.println("Do you want to play again? (Yes/No):");
            String playAgain = scanner.next();

            if (!playAgain.equalsIgnoreCase("yes")){
                System.out.println("Thanks for playing! your total score: Rounds won -" + totalRoundsWon);
                break;
            }
        }

        scanner.close();
    }
}
