import java.util.Arrays;

public class LowestScoreDiceGame {
    public static void main(String[] args) {
        int[] dice = new int[5];
        int totalScore = 0;

        // Play the game for each round
        while (true) {
            // Roll the dice
            rollDice(dice);

            // Check for any 3's
            if (containsThree(dice)) {
                System.out.println("This roll contains a 3. Score for this round: 0");
                totalScore += 0;
            } else {
                // Find the lowest die
                int lowestDie = findLowestDie(dice);
                System.out.println("Lowest die is: " + lowestDie);
                totalScore += lowestDie;
            }

            // Check if all dice are removed
            if (allDiceRemoved(dice)) {
                break;
            }
        }

        System.out.println("Total score for the game: " + totalScore);
    }

    // Method to roll the dice
    public static void rollDice(int[] dice) {
        for (int i = 0; i < dice.length; i++) {
            dice[i] = (int) (Math.random() * 6) + 1;
        }
        System.out.println("Dice rolled: " + Arrays.toString(dice));
    }

    // Method to check if the array contains any 3's
    public static boolean containsThree(int[] dice) {
        for (int die : dice) {
            if (die == 3) {
                return true;
            }
        }
        return false;
    }

    // Method to find the lowest die
    public static int findLowestDie(int[] dice) {
        int min = Integer.MAX_VALUE;
        for (int die : dice) {
            if (die < min) {
                min = die;
            }
        }
        return min;
    }

    // Method to check if all dice are removed
    public static boolean allDiceRemoved(int[] dice) {
        for (int die : dice) {
            if (die != 0) {
                return false;
            }
        }
        return true;
    }
}
