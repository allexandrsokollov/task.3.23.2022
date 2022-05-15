package vsu.cs.sokolov;


import vsu.cs.sokolov.entities.*;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String path = "C:\\Users\\Alexandr\\IdeaProjects\\task.3.23.2022\\appointments.txt";

        HashMap<Integer, Integer> resultsOnMuQueue = Printer.taskOnMyQueue(
                Printer.readDataFromFileToAdditionRow(path));

        HashMap<Integer, Integer> resultsOnSystemQueue = Printer.taskOnSystemQueue(
                Printer.readDataFromFileToAdditionRow(path));


        System.out.println("My queue");
        for (Map.Entry<Integer, Integer> entry : resultsOnMuQueue.entrySet()) {
            System.out.println("id: " + entry.getKey() + "  time: " + entry.getValue());
        }

        System.out.println("\n\nSystem Queue");
        for (Map.Entry<Integer, Integer> entry : resultsOnSystemQueue.entrySet()) {
            System.out.println("id: " + entry.getKey() + "  time: " + entry.getValue());
        }
    }
}
