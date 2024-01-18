public class test_time_only {
	public static void main(String[] args) {
		time_only time = new time_only(12, 34, 50);
		try {
			time.set_second(65);
		}
		catch (IllegalArgumentException iae) {
			System.out.println("Problem with time_only: " + iae.getMessage());
		}
		System.out.println(time);
	}
}
