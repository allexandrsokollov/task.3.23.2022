package vsu.cs.sokolov;

import vsu.cs.sokolov.entities.Appointment;
import vsu.cs.sokolov.entities.Printer;


public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();



        for (int i = 0; i < 10; i++) {
            printer.addAppointment(Appointment.getRandomAppointment());
        }

        printer.print();

    }
}
