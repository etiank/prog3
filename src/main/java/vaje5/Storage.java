package vaje5;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Storage {

    private ArrayList<Integer> tickets = new ArrayList<>();
    private ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private Lock readLock = rwLock.readLock();
    private Lock writeLock = rwLock.writeLock();


    public synchronized void addTicket(int ticketId){
        //tickets.add(ticket);
        writeLock.lock();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        tickets.add(ticketId);
        writeLock.unlock();

    }

    public synchronized boolean ticketExists(int ticketId) {
        readLock.lock();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        boolean exists = tickets.contains(ticketId);
        readLock.unlock();
        return exists;
    }

    /*public void removeTicket(int ticket){
        int ticketIndex = tickets.indexOf(ticket);
        tickets.remove(ticketIndex);
    }*/

    public synchronized void removeTicket(int ticketId){
        writeLock.lock();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int index = tickets.indexOf(ticketId);
        if (index != -1){
            tickets.remove(index);
        }
        writeLock.unlock();

    }

}
