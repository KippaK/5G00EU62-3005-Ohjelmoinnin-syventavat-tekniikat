public class Event : IComparable
{
    private string description;
    private EventCategory category;

    public string Description
    {
        get => description;
        set
        {
            ArgumentNullException.ThrowIfNullOrEmpty(value);

            if (value.Length > 500)
            {
                throw new ArgumentException("Description is too long");
            }

            description = value;
        }
    }

    public EventCategory Category
    {
        get => category;
        set
        {
            ArgumentNullException.ThrowIfNull(value);

            category = value;
        }
    }

    public DateOnly Date { get; set; }

    public Event(DateOnly date, string description, EventCategory category)
    {
        Date = date;
        Description = description;
        Category = category;
    }

    public override string ToString()
    {
        return $"{Date} {Description} ({Category})";
    }

    public int CompareTo(object obj)
    {
        if (obj == null)
        {
            return 1;
        }

        Event otherEvent = obj as Event;
        if (otherEvent != null)
        {
            return Date.CompareTo(otherEvent.Date);
        }
        else
        {
            throw new ArgumentException("Object is not an Event");
        }
    }
}
