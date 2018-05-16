//NAME:Erika Vargas
//EMAIL:erika.vargas@bellevuecollege.edu
//SID: 950638445
//DATE: 05/18/2018
//Description: This program is a guessing game where the user chooses a number and the computer will attempt to guess it
// using prompts that inform the computer whether its guesses are high or

import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    public static void main(String[] args) {
        range();
    }

//range method set the range for which a random number will be chosen by the computer
    public static void range() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int maximum = 100;
        int minimum = 1;
        int numb;
        System.out.println("Think of a number from " + minimum + " to " + maximum);
        numb = rand.nextInt(maximum - minimum) + minimum;
        testHighLowCorrect(numb, maximum, minimum);
    }

// updating method changes the range of numbers (maximum and minimum) according to the responses by the user
    public static void updatingRange(int maximum, int minimum) {
        Random rand = new Random();
        int newNumb;
        newNumb = rand.nextInt(maximum - minimum) + minimum;
        testHighLowCorrect(newNumb, maximum, minimum);
    }

// testingHighLowCorrect method evaluates the responses by the user and executes a new random number guess
    public static void testHighLowCorrect(int numb, int maximum, int minimum) {
        Scanner sc = new Scanner(System.in);
        String input;
        System.out.println("Is number " + numb + "  correct, low or high?");
        input = sc.next();

        boolean isHigh = input.equalsIgnoreCase("h") || input.equalsIgnoreCase("high");
        boolean isLow = input.equalsIgnoreCase("l") || input.equalsIgnoreCase("low");
        boolean isCorrect = input.equalsIgnoreCase("c") || input.equalsIgnoreCase("correct");

        if (isHigh) {
//                int maxNumber = newNumb;
            System.out.println("OK, I will guess again");
            updatingRange(numb - 1, minimum);
        } else if (isLow) {
//                int minNumber = newNumb;
            System.out.println("OK, I will guess again");
            updatingRange(maximum, numb + 1);
        } else if (isCorrect) {
            playAgain(sc);
        }
    }

// playAgain method executes after the computer has guessed the correct number, this methos prompts the user to play
// again or exit the game.
    public static void playAgain(Scanner sc) {
        System.out.println("Good game, play again? Y/N");
        String input = sc.next();

        if (input.substring(0, 1).equalsIgnoreCase("y")) {
            range();
        } else {
            System.out.println("Thanks for playing!");
        }
    }
}










