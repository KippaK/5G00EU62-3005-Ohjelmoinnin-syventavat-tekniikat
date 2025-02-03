import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Today {
    private List<Event> events;

    public Today() {
        this.events = new ArrayList<>();
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java Today --MM-DD primary/secondary");
            System.exit(1);
        }

        LocalDate queryDate = parseDate(args[0]);
        if (queryDate == null) {
            System.err.println("Invalid date format. Use --MM-DD.");
            System.exit(1);
        }

        Category queryCategory = Category.parse(args[1]);
        if (queryCategory == null) {
            System.err.println("Invalid category format. Use primary/secondary.");
            System.exit(1);
        }

        Today app = new Today();
        app.addEvents();
        app.report(queryDate, queryCategory);
    }

    private static LocalDate parseDate(String dateStr) {
        if (!dateStr.matches("--\\d{2}-\\d{2}")) {
            return null;
        }
        try {
            String[] parts = dateStr.substring(2).split("-");
            int month = Integer.parseInt(parts[0]);
            int day = Integer.parseInt(parts[1]);

            if (month < 1 || month > 12) {
                System.err.println("Error: Invalid month. Must be between 01 and 12.");
                return null;
            }

            LocalDate tempDate = LocalDate.of(LocalDate.now().getYear(), month, 1);
            int maxDays = tempDate.lengthOfMonth();

            if (day < 1 || day > maxDays) {
                System.err.println("Error: Invalid day for the given month. Must be between 01 and " + maxDays + ".");
                return null;
            }

            return LocalDate.of(LocalDate.now().getYear(), month, day);
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid number format. Use --MM-DD.");
            return null;
        }
    }

    private void report(LocalDate queryDate, Category queryCategory) {
        List<Event> filteredEvents = new ArrayList<>();

        for (Event event : events) {
            if (isSameDate(queryDate, event.getDate()) && event.getCategory().matches(queryCategory)) {
                filteredEvents.add(event);
            }
        }

        if (filteredEvents.isEmpty()) {
            System.out.println("No events found for given criteria.");
            return;
        }

        Collections.sort(filteredEvents, (e1, e2) -> e2.getDate().compareTo(e1.getDate()));
        for (Event event : filteredEvents) {
            System.out.println(event.getDate().getYear() + ": " + event.getDescription());
        }
    }

    private boolean isSameDate(LocalDate queryDate, LocalDate eventDate) {
        return queryDate.getMonth() == eventDate.getMonth() && queryDate.getDayOfMonth() == eventDate.getDayOfMonth();
    }

    private void addEvents() {
        events.add(new Event(LocalDate.of(2023, 9, 19), "Java SE 21 released", new Category("oracle", "java")));
        events.add(new Event(LocalDate.of(2022, 9, 20), "Java SE 19 released", new Category("oracle", "java")));
        events.add(new Event(LocalDate.of(2021, 9, 14), "Java SE 17 released", new Category("oracle", "java")));
        events.add(new Event(LocalDate.of(2020, 11, 12), "macOS 11 Big Sur released", new Category("apple", "macos")));
        events.add(new Event(LocalDate.now(), "Test event for today", new Category("test", "test")));
    }
}
