import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;

public class FXListView extends Application {

    private ListView<Event> listView;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Event List View");

        // Create a ListView to display events
        listView = new ListView<>();

        // Add corrected events to the EventManager
        EventManager eventManager = EventManager.getInstance();

        eventManager.addEvent(new Event(LocalDate.parse("2020-11-12"), "macOS 11 Big Sur released", "apple"));
        eventManager.addEvent(new Event(LocalDate.parse("2015-09-30"), "OS X 10.11 El Capitan released", "apple"));
        eventManager.addEvent(new Event(LocalDate.parse("2019-10-07"), "macOS 10.15 Catalina released", "apple"));
        eventManager.addEvent(new Event(LocalDate.parse("2017-09-25"), "macOS 10.13 High Sierra released", "apple"));
        eventManager.addEvent(new Event(LocalDate.parse("2007-10-26"), "Mac OS X 10.5 Leopard released", "apple"));
        eventManager.addEvent(new Event(LocalDate.parse("2011-07-20"), "Mac OS X 10.7 Lion released", "apple"));
        eventManager.addEvent(new Event(LocalDate.parse("2013-10-22"), "OS X 10.9 Mavericks released", "apple"));
        eventManager.addEvent(new Event(LocalDate.parse("2018-09-24"), "macOS 10.14 Mojave released", "apple"));
        eventManager.addEvent(new Event(LocalDate.parse("2021-10-25"), "macOS 12 Monterey released", "apple"));
        eventManager.addEvent(new Event(LocalDate.parse("2012-07-25"), "OS X 10.8 Mountain Lion released", "apple"));
        eventManager.addEvent(new Event(LocalDate.parse("2016-09-20"), "macOS 10.12 Sierra released", "apple"));
        eventManager.addEvent(new Event(LocalDate.parse("2009-08-28"), "Mac OS X 10.6 Snow Leopard released", "apple"));
        eventManager.addEvent(new Event(LocalDate.parse("2023-09-26"), "macOS 14 Sonoma released", "apple"));
        eventManager.addEvent(new Event(LocalDate.parse("2005-04-29"), "Mac OS X 10.4 Tiger released", "apple"));
        eventManager.addEvent(new Event(LocalDate.parse("2022-10-24"), "macOS 13 Ventura released", "apple"));
        eventManager.addEvent(new Event(LocalDate.parse("2014-10-16"), "OS X 10.10 Yosemite released", "apple"));

        // Rerun the sorting logic to update the ListView in descending order (newest first)
        ObservableList<Event> events = FXCollections.observableArrayList(eventManager.getEvents());
        events.sort((event1, event2) -> event2.compareTo(event1)); // Compare in descending order
        listView.setItems(events);

        // Create a VBox layout and add the ListView
        VBox vbox = new VBox(listView);

        // Create the scene and set it to the stage
        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

