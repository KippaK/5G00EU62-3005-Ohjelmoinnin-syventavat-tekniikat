using System;

class TestEvent
{
    static void Main()
    {
        // Create EventCategory instances
        EventCategory category1 = new EventCategory { Primary = "apple", Secondary = "macos" };
        EventCategory category2 = new EventCategory { Primary = "microsoft", Secondary = "dotnet" };
        EventCategory category3 = new EventCategory { Primary = "programming" };

        // Create Event instances using EventCategory
        Event event1 = new Event(new DateOnly(2024, 2, 21), "Event 1 Description", category1);
        Event event2 = new Event(new DateOnly(2024, 3, 15), "Event 2 Description", category2);
        Event event3 = new Event(new DateOnly(2024, 4, 10), "Event 3 Description", category3);

        // Display events
        Console.WriteLine(event1.ToString());
        Console.WriteLine(event2.ToString());
        Console.WriteLine(event3.ToString());

        // Compare events
        Console.WriteLine("Comparing events:");
        Console.WriteLine($"Event 1 compared to Event 2: {event1.CompareTo(event2)}");
        Console.WriteLine($"Event 2 compared to Event 3: {event2.CompareTo(event3)}");
        Console.WriteLine($"Event 3 compared to Event 1: {event3.CompareTo(event1)}");
    }
}
