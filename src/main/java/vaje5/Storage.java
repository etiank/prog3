package vaje5;

import java.util.ArrayList;

public class Storage {

    private ArrayList<Integer> tickets = new ArrayList<>();

    public synchronized void addTicket(int ticket){
        tickets.add(ticket);
    }

    public synchronized boolean ticketExists(int ticket) {
        return tickets.contains(ticket);
    }

    /*public void removeTicket(int ticket){
        int ticketIndex = tickets.indexOf(ticket);
        tickets.remove(ticketIndex);
    }*/

    public synchronized void removeTicket(int ticket){
        tickets.remove((Integer) ticket);
    }

}
