package vsu.cs.sokolov.entities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class Printer {
    private int time;
    private MyPriorityQueue<Appointment> additionRow;


    public Printer() {
        time = 0;

        Runnable runnable = () -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    time++;
                    System.out.println(time);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }


    public MyPriorityQueue<Appointment> getAdditionRow() {
        return additionRow;
    }

    public void readDataFromFileToAdditionRow(String filepath) {
        String[] fileData;
        try {
            fileData = FileReader.getFileData("C:\\Users\\Alexandr\\IdeaProjects\\task.3.23.2022\\appointments.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        FileHandler fileHandler = new FileHandler(fileData);
        ArrayList<Appointment> appointments = fileHandler.getListOfAppointments();

        Comparator<Appointment> comparator = (o1, o2) -> {

            if (o1.getReceivingTime() < o2.getReceivingTime()) {
                return 1;
            } else if (o1.getReceivingTime() > o2.getReceivingTime()) {
                return -1;
            } else if (o1.getPriority() > o2.getPriority()) {
                return 1;
            } else if (o1.getPriority() < o2.getPriority()) {
                return -1;
            } else return Integer.compare(o1.getId(), o2.getId());
        };

        additionRow = new MyPriorityQueue<>(comparator);

        for (Appointment appointment : appointments) {
            additionRow.add(appointment);
        }
    }

}
