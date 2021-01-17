package innerclass.controller;
import java.util.*;

public class Controller {
    // A class from java.util to hold Event objects:
    List<Event> eventList = new LinkedList<>();

    public void addEvent(Event c) {
        eventList.add(c);
    }

    //Iterator<Event> eventIterator = eventList.listIterator();

    public void run() {
        while (eventList.size() > 0) {
            // Make a copy so you're not modifying the list
            // while you're selecting the elements in it:
            List<Event> copy = new LinkedList<>(eventList);
            Iterator eventIterator = copy.iterator();
            while (new LinkedList<>(eventList).iterator().hasNext()) {
                Event event = (Event) eventIterator.next();
                if (event.ready()) {
                    System.out.println(event);
                    event.action();
                    // eventIterator.remove();
                }
            }
        }
    }
}