import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Arrays;

public class EventTest {
    public static void main(String[] args) {
        Category appleMacOS = new Category("apple", "macos");

        Event[] events = {
            new Event(LocalDate.parse("2024-09-16"),"macOS 15 Sequioa released",appleMacOS),
            new Event(LocalDate.parse("2023-09-26"),"macOS 14 Sonoma released",appleMacOS),
            new Event(LocalDate.parse("2022-10-24"),"macOS 13 Ventura released",appleMacOS),
            new Event(LocalDate.parse("2021-10-25"),"macOS 12 Monterey released",appleMacOS),
            new Event(LocalDate.parse("2020-11-12"),"macOS 11 Big Sur released",appleMacOS),
        };

        for (Event event : events) {
            String dayName = event
                .getDate()
                .getDayOfWeek()
                .getDisplayName(
                    TextStyle.FULL, 
                    Locale.getDefault()
                );

            String releaseName = event
                .getDescription()
                .substring(
                    0,
                    event.getDescription().length() - 9
                );

            System.out.print(releaseName + " was released on a " + dayName + "\n");
        }

        String[] osNames = new String[events.length];

        for (int i = 0; i < events.length; i++) { 
            osNames[i] = events[i]
                .getDescription()
                .substring(
                    9, 
                    events[i]
                        .getDescription()
                        .length() - 9
                );
        }

        Arrays.sort(osNames);
        System.out.printf("In aplhabetical order: %s\n", Arrays.toString(osNames));
    }
}
