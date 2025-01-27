import java.util.Random;

public class generate_random {
	public static void main(String[] args) {
		Random rand = new Random();

		int rand_int = rand.nextInt(99) + 1;

		System.out.printf("Luku, jota ajattelen on " + rand_int + '\n');
	}
}
