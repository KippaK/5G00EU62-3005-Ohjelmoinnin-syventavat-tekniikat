type Event =
    { Description : string
      Category : string
      Date : System.DateOnly }

let events = [ 
    { Description = ".NET 8 released"
      Category = "microsoft/dotnet"
      Date = System.DateOnly(2023, 11, 14) }

    { Description = "macOS 14 Sonoma released"
      Category = "apple/macos"
      Date = System.DateOnly(2023, 09, 26) }

    { Description = "Java SE 21 released"
      Category = "java"
      Date = System.DateOnly(2023, 09, 19) }
    // Lisätään tapahtumia
    { Description = "Python 4.0 released"
      Category = "python"
      Date = System.DateOnly(2023, 10, 5) }

    { Description = "Angular 13 released"
      Category = "javascript/angular"
      Date = System.DateOnly(2023, 10, 8) }

    { Description = "Unity 2023 LTS released"
      Category = "game-dev/unity"
      Date = System.DateOnly(2023, 10, 15) }
]

let isInMonth event month = event.Date.Month = month

printfn "events has %d elements" events.Length

let septemberEvents = events |> List.filter (fun e -> isInMonth e 9)

printfn "\nEvents in September:"
for event in septemberEvents do
    printfn "%A - %s" event.Date event.Description

let filterByCategory events category =
    events |> List.filter (fun e -> e.Category = category)

let dotnetEvents = filterByCategory events "microsoft/dotnet"

printfn "\n.NET Events:"
for event in dotnetEvents do
    printfn "%A - %s" event.Date event.Description
