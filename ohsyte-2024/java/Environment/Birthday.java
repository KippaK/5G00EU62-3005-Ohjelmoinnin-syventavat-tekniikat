import java.time.LocalDate;

public class Birthday {
    public static void main(String[] args) {
        String birthdateValue = System.getenv("BIRTHDATE");

        LocalDate birthdate = LocalDate.parse(birthdateValue);

        LocalDate today = LocalDate.now();

        if (isSameDate(today, birthdate)) {
            System.out.println("Happy birthday!");
        }

        long daysOld = today.toEpochDay() - birthdate.toEpochDay();
        System.out.println(String.format("You are %d days old.", daysOld));

        if (daysOld % 1000 == 0 && daysOld > 0) {
            System.out.println("That's a nice round number!");
        }

    }

    public static boolean isSameDate(LocalDate date1, LocalDate date2) {
        return date1.getDayOfMonth() == date2.getDayOfMonth() &&
            date1.getMonth() == date2.getMonth();
    }
}
