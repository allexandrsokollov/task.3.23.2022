package vsu.cs.sokolov.entities;

import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    String[] strings;

    public FileHandler(String[] strings) {
        this.strings = strings;
    }

    public ArrayList<Appointment> getListOfAppointments() {
        Scanner scanner;
        ArrayList<Appointment> result = new ArrayList<>();

        for (String str : strings) {
            scanner = new Scanner(str);
            result.add(new Appointment(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        }
        return result;
    }


}
