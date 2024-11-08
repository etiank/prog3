package vaje5;

public class Event {

    private int ticketId;
    private EventType eventType;

    // ALT + INSERT
    public Event(int ticketId, EventType eventType) {
        this.ticketId = ticketId;
        this.eventType = eventType;
    }

    public int getTicketId() {
        return ticketId;
    }

    public EventType getEventType() {
        return eventType;
    }
}
