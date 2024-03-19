public class EventManager
{
    private readonly List<Event> _events = new List<Event>();

    public bool AddEvent(Event e)
    {
        _events.Add(e);
        return true;
    }

    public List<Event> GetEvents()
    {
        return new List<Event>(_events); // Return a copy to prevent modification of the original list
    }

    public bool ReadEvents(string eventsPath)
    {
        if (string.IsNullOrEmpty(eventsPath) || !File.Exists(eventsPath))
        {
            Console.Error.WriteLine($"Event file {eventsPath} not found");
            return false;
        }

        _events.Clear();

        try
        {
            using (var reader = new StreamReader(eventsPath))
            {
                string line;
                while ((line = reader.ReadLine()) != null)
                {
                    var parts = line.Split(',');
                    if (parts.Length < 3)
                        continue;

                    DateTime date;
                    if (!DateTime.TryParse(parts[0], out date))
                    {
                        Console.Error.WriteLine($"Invalid date format: {parts[0]}, ignoring event");
                        continue;
                    }

                    var description = new Description(parts[1]);
                    var category = new Category(parts[2]);

                    _events.Add(new Event(date, description, category));
                }
            }
            return true;
        }
        catch (Exception ex)
        {
            Console.Error.WriteLine($"Error reading events file: {ex.Message}");
            return false;
        }
    }
}