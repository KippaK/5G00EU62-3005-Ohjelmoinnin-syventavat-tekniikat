import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class TestEvent {
    public static void main(String[] args) {
        List<Event> events = new ArrayList<>();
        try {
            events.add(
                new Event(
                    LocalDate.now(),
                    "Testataan roskaa",
                    "java"));
        } catch (Exception e) {
            System.out.println(e.toString());        
        }

        try {
            events.add(
                new Event(
                    LocalDate.now(),
                    "Testataan roskaa part 2",
                    "java"));
        } catch (Exception e) {
            System.out.println(e.toString());        
        }

        try {
            events.add(
                new Event(
                    LocalDate.now(),
                    "Testataan roskaa part 3",
                    "java"));
        } catch (Exception e) {
            System.out.println(e.toString());        
        }

        for (int i = 0; i < events.size(); i++) {
            System.out.println(events.get(i).toString());
        }
    }
}
