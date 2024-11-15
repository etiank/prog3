package vaje5;

import util.LogLevel;
import util.Logger;

public class ValidateTicketConsumer extends Thread{

    private EventQueue queue;
    private Storage storage;

    public ValidateTicketConsumer(EventQueue queue, Storage storage){
        this.queue = queue;
        this.storage = storage;
    }

    @Override
    public void run(){
        Thread.currentThread().setName("ValidateTicketConsumer");

        while(true){
            Event eventToHandle = queue.getEventIfType(EventType.Validateticket);
            if (eventToHandle == null){
                continue;
            }
            if(!storage.ticketExists(eventToHandle.getTicketId())){
                Logger.log("Ticket invalid!", LogLevel.Warn);
                continue;
            }
            Logger.log("Ticket " + eventToHandle.getTicketId() + " valid!", LogLevel.Success);
        }
    }



}
