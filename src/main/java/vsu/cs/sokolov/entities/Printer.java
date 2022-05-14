package vsu.cs.sokolov.entities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Printer {
    private ArrayList<Appointment> appointments;
    private MyPriorityQueue<Appointment> myPriorityQueue;
    private PriorityQueue<Appointment> systemPriorityQueue;

    /**
     * @return a String array.
     * Every element of array has format like id: (id), time (time (sec))
     */
    public String[] getFinalTimeOfPrintingWithMyOwnQueue() {
        int time = 0;

        for (Appointment appointment : appointments) {
            myPriorityQueue.add(appointment);
        }

        String[] results = new String[appointments.size()];

        int counter = 0;
        while  (myPriorityQueue.getHead() != null) {
            Appointment appointment = myPriorityQueue.extract();
            if (time < appointment.getReceivingTime()) {
                time = appointment.getReceivingTime();
            }

            time += appointment.getAmountOfPages();
            results[counter++] = "id: " + appointment.getId() + "  Time: " + time;
        }
        return results;
    }

    public String[] getFinalTimeOfPrintingWithSystemQueue() {
        int time = 0;

        systemPriorityQueue.addAll(appointments);

        String[] results = new String[appointments.size()];

        int counter = 0;
        for (Appointment appointment : systemPriorityQueue) {
            if (time < appointment.getReceivingTime()) {
                time = appointment.getReceivingTime();
            }

            time += appointment.getAmountOfPages();
            results[counter++] = "id: " + appointment.getId() + "  Time: " + time;
        }
        return results;
    }


    public void readDataFromFileToAdditionRow(String filepath) {
        String[] fileData;
        try {
            fileData = FileReader.getFileData(filepath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        FileHandler fileHandler = new FileHandler(fileData);
        this.appointments = fileHandler.getListOfAppointments();

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

        myPriorityQueue = new MyPriorityQueue<>(comparator);
        systemPriorityQueue = new PriorityQueue<>(comparator);
    }

}
