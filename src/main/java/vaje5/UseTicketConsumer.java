package vaje5;

import util.LogLevel;
import util.Logger;

public class UseTicketConsumer extends Thread {

    private EventQueue eventQueue;
    private Storage storage;

    public UseTicketConsumer(EventQueue eventQueue, Storage storage){
        this.eventQueue = eventQueue;
        this.storage = storage;
    }

    @Override
    public void run(){
        Thread.currentThread().setName("UseTicketConsumer");

        while(true){
            Event eventToHandle = eventQueue.getEventIfType(EventType.UseTicket);
            if (eventToHandle == null){
                continue;
            }

            if (!storage.ticketExists(eventToHandle.getTicketId())){
                Logger.log("Invalid ticket!", LogLevel.Warn);
                continue;
            }

            storage.removeTicket(eventToHandle.getTicketId());
            Logger.log("Ticket " + eventToHandle.getTicketId() + " used!", LogLevel.Success);
        }
    }

}
