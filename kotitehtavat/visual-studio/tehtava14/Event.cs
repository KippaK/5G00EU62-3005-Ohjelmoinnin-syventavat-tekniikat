public class Event
{
    public DateTime Date { get; }
    public Description Description { get; }
    public Category Category { get; }

    public Event(DateTime date, Description description, Category category)
    {
        Date = date;
        Description = description;
        Category = category;
    }

    public override string ToString()
    {
        return $"{Date.ToShortDateString()} {Description} ({Category})";
    }
}