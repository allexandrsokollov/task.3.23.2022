package vsu.cs.sokolov.entities;

public class Appointment {
    private int amountOfPages;
    private int priority;
    private final int id;
    private long receivingTime;

    public Appointment(long receivingTime, int priority, int amountOfPages,  int id) {
        this.amountOfPages = amountOfPages;
        this.priority = priority;
        this.id = id;
        this.receivingTime = receivingTime;
    }

    @Override
    public String toString() {
        return "amountOfPages=" + amountOfPages + ", pri=" + priority + ", id=" + id +
                ", Time=" + receivingTime + '\n';
    }
    public void setReceivingTime(long receivingTime) {
        this.receivingTime = receivingTime;
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
