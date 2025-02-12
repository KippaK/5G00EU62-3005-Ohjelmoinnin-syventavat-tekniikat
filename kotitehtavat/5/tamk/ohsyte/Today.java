package tamk.ohsyte;

import java.nio.file.*;
import java.time.MonthDay;
import java.util.Collections;
import java.util.List;

public class Today {
    public static void main(String[] args) {
        String homeDir = System.getProperty("user.home");
        Path eventsFilePath = Paths.get(homeDir, ".today", "events.csv");

        if (!Files.exists(eventsFilePath)) {
            System.err.println("CSV file not found in " + eventsFilePath);
            return;
        }

        EventProvider provider = new CSVEventProvider(eventsFilePath.toString());
        MonthDay today = MonthDay.now();

        List<Event> events = provider.getEventsOfDate(today);
        Collections.sort(events);
        Collections.reverse(events);

        for (Event event : events) {
            System.out.println(event);
        }
    }
}
