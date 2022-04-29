package vsu.cs.sokolov;

import vsu.cs.sokolov.entities.Appointment;
import vsu.cs.sokolov.entities.Printer;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Scanner in = new Scanner(System.in);


        int switcher = 0;
        Appointment tempAppointment;

        while (switcher == 0) {
            System.out.println("Press 2 to add random appointment\nPress 3 to add Appointment from file");


            while (!in.hasNextInt()) {

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

            switcher = in.nextInt();

            if (switcher == 2) {
                printer.addAppointment(Appointment.getRandomAppointment());
            }
            printer.print();

            switcher = 0;

        }

    }
}
