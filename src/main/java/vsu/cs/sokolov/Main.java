package vsu.cs.sokolov;


import vsu.cs.sokolov.entities.Appointment;
import vsu.cs.sokolov.entities.FileHandler;
import vsu.cs.sokolov.entities.FileReader;
import vsu.cs.sokolov.entities.MyPriorityQueue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

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

        MyPriorityQueue<Appointment> priorityQueue = new MyPriorityQueue<>(comparator);

        for (Appointment appointment : appointments) {
            priorityQueue.add(appointment);
        }

        System.out.println(priorityQueue);

    }
}
