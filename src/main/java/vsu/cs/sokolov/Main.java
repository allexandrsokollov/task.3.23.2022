package vsu.cs.sokolov;


import vsu.cs.sokolov.entities.*;

public class Main {
    public static void main(String[] args) {

        Printer printer = new Printer();
        printer.readDataFromFileToAdditionRow("C:\\Users\\Alexandr\\IdeaProjects\\task.3.23.2022\\appointments.txt");

        System.out.println(printer.getAdditionRow());

    }
}
