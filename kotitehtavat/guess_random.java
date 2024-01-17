import java.util.Scanner;
import java.util.Random;

public class guess_random {
	static int guess() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a guess (1 - 100): ");
		return scan.nextInt();
	}

	public static void main(String[] args) {
		Random rand = new Random();
		int correct = rand.nextInt(99) + 1;
		for (int i = 0; i < 7; i++) {
			int guess = guess();
			if (guess == correct) {
				System.out.println("You guessed correctly!");
				return;
			}
		}
		System.out.println("You ran out of attempts.");
		System.out.println("Correct answer was " + correct);
		return;
	}	
}
