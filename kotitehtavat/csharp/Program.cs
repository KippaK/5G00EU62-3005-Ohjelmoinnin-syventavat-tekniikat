class Program
{
    static void Main(string[] args)
    {
        if (args.Length != 2)
        {
            Console.WriteLine("Usage: dotnet run <start_date> <end_date>");
            return;
        }

        if (!DateOnly.TryParse(args[0], out var startDate) || !DateOnly.TryParse(args[1], out var endDate))
        {
            Console.WriteLine("Invalid date format. Please use ISO 8601 format (yyyy-MM-dd).");
            return;
        }

        EventManager eventManager = EventManager.Instance;
        eventManager.EventsPath = "events.csv";
        // Read events from the file
        if (eventManager.ReadEvents())
        {
            // Use LINQ to filter events based on the date range
            var filteredEvents = eventManager.Events
                .Where(e => e.Date >= startDate && e.Date <= endDate)
                .OrderBy(e => e.Date);

            // Display the filtered events
            Console.WriteLine($"Events between {startDate} and {endDate}:");
            foreach (var filteredEvent in filteredEvents)
            {
                Console.WriteLine(filteredEvent.ToString());
            }
            Console.WriteLine("");
        }
    }
}
