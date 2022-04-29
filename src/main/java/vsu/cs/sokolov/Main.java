package vsu.cs.sokolov;

import vsu.cs.sokolov.entities.Appointment;
import vsu.cs.sokolov.entities.FileHandler;
import vsu.cs.sokolov.entities.FileReader;
import vsu.cs.sokolov.entities.Printer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Scanner in = new Scanner(System.in);

        int switcher = 0;

        while (switcher == 0) {
            System.out.println("Press 2 to add random appointment\nPress 3 to add Appointment from file\n" +
                    "And else if u want to close app");

            switcher = in.nextInt();
            String path;

            System.out.println("Enter file path:");

            path = in.next();

            System.out.println();

            ArrayList<Appointment> appointments = new ArrayList<>();

            if (switcher == 3) {
                try {
                    FileHandler fh = new FileHandler(FileReader.getFileData(path));
                    appointments = fh.getListOfAppointments();

                    for (Appointment appointment : appointments) {
                        printer.addAppointment(appointment);
                    }
                    System.out.println();

                    printer.print();
                    switcher = 0;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (switcher == 2) {
                printer.addAppointment(Appointment.getRandomAppointment());
                switcher = 0;
            } else {
                switcher = -1;
            }

        }
    }
}
