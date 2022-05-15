package vsu.cs.sokolov.entities;

import java.util.Objects;

public class Appointment {
    private final int amountOfPages;
    private final int priority;
    private final int id;
    private final int receivingTime;

    public Appointment(int receivingTime, int priority, int amountOfPages,  int id) {
        this.amountOfPages = amountOfPages;
        this.priority = priority;
        this.id = id;
        this.receivingTime = receivingTime;
    }

    public Appointment(Appointment appointment) {
        this.amountOfPages = appointment.amountOfPages;
        this.priority = appointment.priority;
        this.id = appointment.id;
        this.receivingTime = appointment.receivingTime;
    }

    @Override
    public String toString() {
        return "amountOfPages=" + amountOfPages + ", pri=" + priority + ", id=" + id +
                ", Time=" + receivingTime + '\n';
    }

    public int getReceivingTime() {
        return receivingTime;
    }

    public int getAmountOfPages() {
        return amountOfPages;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return amountOfPages == that.amountOfPages && priority == that.priority && id == that.id && receivingTime == that.receivingTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amountOfPages, priority, id, receivingTime);
    }

    public int getId() {
        return id;
    }
}
