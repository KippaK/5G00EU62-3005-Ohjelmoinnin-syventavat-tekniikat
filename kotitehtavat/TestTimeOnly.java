public class TestTimeOnly {
    public static void main(String[] args) {
        TimeOnly time = new TimeOnly(12, 34, 50);
        try {
            time.setSecond(65);
        } catch (IllegalArgumentException iae) {
            System.out.println("Problem with TimeOnly: " + iae.getMessage());
        }
        System.out.println(time);
    }
}
