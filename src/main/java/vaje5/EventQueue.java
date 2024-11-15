package vaje5;
import util.Logger;
import java.util.LinkedList;

public class EventQueue {

    private LinkedList<Event> queue = new LinkedList<>();

    public synchronized int getSize(){
        return queue.size();
    }

    public synchronized void addEvent(Event event){
        queue.add(event);
        Logger.log("Event " + event.getEventType() + " added to queue Size: " + queue.size());
    }

    public synchronized Event getEventIfType(EventType type){
        if (queue.isEmpty()) {return null;}
        if (queue.getFirst().getEventType() != type){
            return null;
        }

        Event event = queue.pop(); // push & pop ponavadi za vse data structures
        Logger.log("Event " + event.getEventType() + " removed from the queue. Size: " + queue.size());
        return event;

    }

}
