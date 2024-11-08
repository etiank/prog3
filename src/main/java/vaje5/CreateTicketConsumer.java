package vaje5;

public class CreateTicketConsumer {




    @Override
    public void run(){
        Thread.currentThread().setName("UseTicketConsumer");

        while(true){
            Event eventToHandle = eventQueue.getEventOfType(EventType.UseTicket);
            if (eventToHandle == null){
                continue;
            }

            if (!storage.ticketExists(eventToHandle.getTicketId())){
                Logger.log("Invalid ticket!", LogLevel.Warn);
                continue;
            }

            storage.removeTicket(eventToHandle.getTicketId());
        }
    }

}
