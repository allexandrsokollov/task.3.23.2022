package vsu.cs.sokolov.entities;

import java.util.PriorityQueue;

public class Printer {
    private final PriorityQueue<Appointment> queue;

    public Printer() {

        this.queue = new PriorityQueue<>((o2, o1) -> {
            if (o1.getPriority() > o2.getPriority()) {
                return 1;
            } else if (o1.getPriority() < o2.getPriority()) {
                return -1;
            } else if (o1.getReceivingTime() > o2.getReceivingTime()) {
                return 1;
            } else if (o1.getReceivingTime() < o2.getReceivingTime()){
                return -1;
            } else if (o1.getId() > o2.getId()) {
                return 1;
            } else if (o1.getId() < o2.getId()) {
                return -1;
            }
            return 0;
        });
    }

    public void print() {
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    public void addAppointment(Appointment appointment) {
        queue.add(appointment);
    }
}
