import java.time.LocalDate;
import java.lang.Comparable;

public class Event implements Comparable<Event> {
    private LocalDate time;
    private Description description;
    private Category category;

    public Event(
        LocalDate time,
        String description,
        String category)
    {
        this.time = time;
        this.description = new Description(description);
        this.category = new Category(category);
    }    

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setDescription(String description) {
        this.description.setDescription(description);
    }

    public String getDescription() {
        return this.description.getDescription();
    }
    
    public void setCategory(String category) {
        this.category.setCategory(category);
    }

    public String getCategory() {
        return this.category.getCategory();
    }

    @Override
    public int compareTo(Event event) {
        return this.time.compareTo(event.getTime());
    }

    @Override
    public String toString() {
        return (
            "When: " + time.toString() +
            "\nDesc: " + description.toString() + 
            "\nWhat: " + category.toString() + '\n');
    }
}
