using System;
using System.Collections.Generic;
using System.Globalization;
using System.IO;
using System.Linq;

class EventCsv
{
    static void Main()
    {
        List<Event> events = ReadEventsFromCsv("EventSample.csv");

        // Sort events by date in descending order (newest first)
        events.Sort((e1, e2) => e2.Date.CompareTo(e1.Date));

        // Print events to console
        foreach (var ev in events)
        {
            Console.WriteLine(ev.ToString());
        }
    }

    static List<Event> ReadEventsFromCsv(string filePath)
    {
        List<Event> events = new List<Event>();

        try
        {
            string[] lines = File.ReadAllLines(filePath);

            foreach (var line in lines.Skip(1)) // Skip header line
            {
                string[] fields = line.Split(',');

                if (fields.Length == 3)
                {
                    DateOnly date = DateOnly.Parse(fields[0], CultureInfo.InvariantCulture);
                    string description = fields[1];
                    string[] categoryParts = fields[2].Split('/');
                    string primaryCategory = categoryParts[0];
                    string secondaryCategory = categoryParts.Length > 1 ? categoryParts[1] : null;

                    EventCategory category = new EventCategory
                    {
                        Primary = primaryCategory,
                        Secondary = secondaryCategory
                    };

                    Event newEvent = new Event(date, description, category);
                    events.Add(newEvent);
                }
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error reading CSV file: {ex.Message}");
        }

        return events;
    }
}
