package vsu.cs.sokolov.entities;

import java.util.Random;

public class Appointment {
    private int amountOfPages;
    private int priority;
    private final int id;
    private long receivingTime;

    public Appointment(int amountOfPages, int priority, int receivingTime) {
        this.amountOfPages = amountOfPages;
        this.priority = priority;
        Random r = new Random();
        receivingTime = 0;
        id = r.nextInt();
    }

    @Override
    public String toString() {
        return "amountOfPages=" + amountOfPages + ", priority=" + priority + ", id=" + id +
                ", receivingTime=" + receivingTime + '\n';
    }
    public void setReceivingTime(long receivingTime) {
        this.receivingTime = receivingTime;
    }

    public static Appointment getRandomAppointment() {
        Random r = new Random();
        return new Appointment(r.nextInt(10), r.nextInt(10), 0);
    }

    public void decrementAmountOfPages() {
        amountOfPages--;
    }

    public long getReceivingTime() {
        return receivingTime;
    }

    public int getAmountOfPages() {
        return amountOfPages;
    }

    public void setAmountOfPages(int amountOfPages) {
        this.amountOfPages = amountOfPages;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getId() {
        return id;
    }
}
