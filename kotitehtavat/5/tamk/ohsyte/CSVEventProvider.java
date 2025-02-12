package tamk.ohsyte;

import org.apache.commons.csv.*;
import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.util.*;

public class CSVEventProvider implements EventProvider {
    private List<Event> events;

    public CSVEventProvider(String fileName) {
        this.events = new ArrayList<>();
        Path path = Paths.get(fileName);

        if (!Files.exists(path)) {
            System.err.println("File '" + fileName + "' not found");
            return;
        }

        try (Reader reader = Files.newBufferedReader(path);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
            
            for (CSVRecord record : csvParser) {
                this.events.add(makeEvent(record));
            }
            System.out.printf("Read %d events from CSV file%n", this.events.size());
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }

    @Override
    public List<Event> getEvents() {
        return this.events;
    }

    @Override
    public List<Event> getEventsOfCategory(Category category) {
        List<Event> result = new ArrayList<>();
        for (Event event : this.events) {
            if (event.getCategory().equals(category)) {
                result.add(event);
            }
        }
        return result;
    }

    @Override
    public List<Event> getEventsOfDate(MonthDay monthDay) {
        List<Event> result = new ArrayList<>();
        for (Event event : this.events) {
            final Month eventMonth = event.getDate().getMonth();
            final int eventDay = event.getDate().getDayOfMonth();
            if (monthDay.getMonth() == eventMonth && monthDay.getDayOfMonth() == eventDay) {
                result.add(event);
            }
        }
        return result;
    }

    private Event makeEvent(CSVRecord record) {
        LocalDate date = LocalDate.parse(record.get("date"));
        String description = record.get("description");
        String categoryString = record.get("category");
        String[] categoryParts = categoryString.split("/");
        String primary = categoryParts[0];
        String secondary = (categoryParts.length == 2) ? categoryParts[1] : null;
        Category category = new Category(primary, secondary);
        return new Event(date, description, category);
    }
}
