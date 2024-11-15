package vaje5;
import util.LogLevel;
import util.Logger;
import vaje6.Lobby;

public class CreateTicketConsumer extends Thread{

    private EventQueue eventQueue;
    private Storage storage;

    public CreateTicketConsumer(EventQueue eventQueue, Storage storage) {
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

            if (storage.ticketExists(eventToHandle.getTicketId())){
                Logger.log("Invalid ticket!", LogLevel.Warn);
                continue;
            }

            //storage.removeTicket(eventToHandle.getTicketId());
            storage.addTicket(eventToHandle.getTicketId());
            Logger.log("Created ticket " + eventToHandle.getTicketId(), LogLevel.Success);
        }
    }

}
