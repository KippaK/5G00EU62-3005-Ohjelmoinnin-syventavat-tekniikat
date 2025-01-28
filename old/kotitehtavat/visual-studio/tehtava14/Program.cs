using System;
using System.Linq;

public class Program
{
    public static void Main(string[] args)
    {
        if (args.Length != 2)
        {
            Console.WriteLine("Usage: dotnet run <start_date> <end_date>");
            return;
        }

        if (!DateTime.TryParse(args[0], out var startDate) || !DateTime.TryParse(args[1], out var endDate))
        {
            Console.WriteLine("Invalid date format. Please use a valid date format.");
            return;
        }

        var eventManager = new EventManager();
        eventManager.ReadEvents("events.csv");

        var filteredEvents = eventManager.GetEvents()
            .Where(e => e.Date >= startDate && e.Date <= endDate)
            .OrderBy(e => e.Date);

        Console.WriteLine($"Events between {startDate.ToShortDateString()} and {endDate.ToShortDateString()}:");
        foreach (var filteredEvent in filteredEvents)
        {
            Console.WriteLine(filteredEvent);
        }
    }
}
