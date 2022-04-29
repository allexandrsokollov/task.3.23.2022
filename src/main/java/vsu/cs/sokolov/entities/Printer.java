package vsu.cs.sokolov.entities;

import java.util.PriorityQueue;

public class Printer {
    private final PriorityQueue<Appointment> queue;
    private long time;
    private final long startTime;

    public Printer() {

        time = 0;
        startTime = System.currentTimeMillis();

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

    public long getTime() {
        time = System.currentTimeMillis() - startTime;
        return time;
    }

    public void print() {

        long stTime;
        int pageNumber = 1;

        while (!queue.isEmpty()) {

            Appointment temp = queue.poll();
            stTime = System.currentTimeMillis();

            System.out.println("file id  " + temp.getId());
            while (temp.getAmountOfPages() != 0) {

                System.out.println("Printing page number: " + pageNumber++);
                temp.decrementAmountOfPages();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


            }
            System.out.println("it taken " + (System.currentTimeMillis() - stTime ) + " millis" );
            stTime = 0;
            System.out.println();
            pageNumber = 1;
        }
    }

    public void addAppointment(Appointment appointment) {
        time = System.currentTimeMillis() - startTime;

        long delay = time % 1000;
        if (delay == 0) {
            queue.add(appointment);
        } else {
            System.out.println("Gotta wait: " + delay + " millis");
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            time += delay;
            appointment.setReceivingTime(time);
            queue.add(appointment);
            System.out.println("added");
        }

    }
}
