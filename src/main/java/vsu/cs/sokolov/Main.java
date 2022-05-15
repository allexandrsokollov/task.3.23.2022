package vsu.cs.sokolov;


import vsu.cs.sokolov.entities.*;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Integer> results = Printer.taskOnMyQueue(
                Printer.readDataFromFileToAdditionRow(
                        "C:\\Users\\Alexandr\\IdeaProjects\\task.3.23.2022\\appointments.txt"));

        for (Map.Entry<Integer, Integer> entry : results.entrySet()) {
            System.out.println("id: " + entry.getKey() + "  time: " + entry.getValue());
        }

    }
}
