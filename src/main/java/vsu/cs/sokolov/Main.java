package vsu.cs.sokolov;


import vsu.cs.sokolov.entities.*;

public class Main {
    public static void main(String[] args) {

        Printer printer = new Printer();
        printer.readDataFromFileToAdditionRow("C:\\Users\\Alexandr\\IdeaProjects\\task.3.23.2022\\appointments.txt");

        String[] timeWithMyQueue = printer.getFinalTimeOfPrintingWithMyOwnQueue();
        String[] timeWithSystemQueue = printer.getFinalTimeOfPrintingWithSystemQueue();


        System.out.println("My queue");
        for (String str : timeWithMyQueue) {
            System.out.println(str);
        }

        System.out.println("\nSystem queue");
        for (String str : timeWithSystemQueue) {
            System.out.println(str);
        }

    }
}
