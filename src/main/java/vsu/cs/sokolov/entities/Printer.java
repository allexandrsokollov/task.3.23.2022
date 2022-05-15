package vsu.cs.sokolov.entities;

import java.io.IOException;
import java.util.*;

public class Printer {
    public static HashMap<Integer, Integer> taskOnMyQueue(Appointment[] appointments) {

        HashMap<Integer, Integer> results = new HashMap<>();

        Comparator<Appointment> comparator = (o1, o2) -> Integer.compare(o2.getReceivingTime(), o1.getReceivingTime());
        MyPriorityQueue<Appointment> timeQueue = new MyPriorityQueue<>(comparator);

        for (Appointment appointment : appointments) {
            timeQueue.add(appointment);
        }

        Comparator<Appointment> printerComparator = (o1, o2) -> {
            if (o1.getPriority() > o2.getPriority()) {
                return 1;
            } else if (o1.getPriority() < o2.getPriority()) {
                return -1;
            } else if (o1.getReceivingTime() < o2.getReceivingTime()) {
                return 1;
            } else if (o1.getReceivingTime() > o2.getReceivingTime()) {
                return -1;
            } else {
                return Integer.compare(o1.getId(), o2.getId());
            }
        };

        MyPriorityQueue<Appointment> printerQueue = new MyPriorityQueue<>(printerComparator);


        int time = 0;
        Appointment current = null;
        while (!timeQueue.isEmpty()) {
            if (current == null) {
                current = timeQueue.extract();
            }

            if (time >= current.getReceivingTime() || (printerQueue.isEmpty())) {
                if (printerQueue.isEmpty() && time < current.getReceivingTime()) {
                    time = current.getReceivingTime();
                }
                printerQueue.add(new Appointment(current));
                current = null;
            } else {
                Appointment temp = printerQueue.extract();
                time += temp.getAmountOfPages();
                results.put(temp.getId(), time);

            }
            if (timeQueue.isEmpty() && current != null) {
                printerQueue.add(current);
            }

        }

        while (!printerQueue.isEmpty()) {
            Appointment temp = printerQueue.extract();

            if (time < temp.getReceivingTime()) {
                time = temp.getReceivingTime();
            }
            time += temp.getAmountOfPages();
            results.put(temp.getId(), time);
        }


        return results;
    }

    public static HashMap<Integer, Integer> taskOnSystemQueue(Appointment[] appointments) {

        HashMap<Integer, Integer> results = new HashMap<>();

        Comparator<Appointment> comparator = (o1, o2) -> Integer.compare(o1.getReceivingTime(), o2.getReceivingTime());
        PriorityQueue<Appointment> timeQueue = new PriorityQueue<>(comparator);

        timeQueue.addAll(Arrays.asList(appointments));

        Comparator<Appointment> printerComparator = (o1, o2) -> {
            if (o1.getPriority() < o2.getPriority()) {
                return 1;
            } else if (o1.getPriority() > o2.getPriority()) {
                return -1;
            } else if (o1.getReceivingTime() > o2.getReceivingTime()) {
                return 1;
            } else if (o1.getReceivingTime() < o2.getReceivingTime()) {
                return -1;
            } else {
                return Integer.compare(o1.getId(), o2.getId());
            }
        };

        PriorityQueue<Appointment> printerQueue = new PriorityQueue<>(printerComparator);


        int time = 0;
        Appointment current = null;
        while (!timeQueue.isEmpty()) {
            if (current == null) {
                current = timeQueue.poll();
            }

            if (time >= current.getReceivingTime() || (printerQueue.isEmpty())) {
                if (printerQueue.isEmpty() && time < current.getReceivingTime()) {
                    time = current.getReceivingTime();
                }
                printerQueue.add(new Appointment(current));
                current = null;
            } else {
                Appointment temp = printerQueue.poll();
                time += temp.getAmountOfPages();
                results.put(temp.getId(), time);

            }
            if (timeQueue.isEmpty() && current != null) {
                printerQueue.add(current);
            }

        }

        while (!printerQueue.isEmpty()) {
            Appointment temp = printerQueue.poll();

            if (time < temp.getReceivingTime()) {
                time = temp.getReceivingTime();
            }
            time += temp.getAmountOfPages();
            results.put(temp.getId(), time);
        }


        return results;
    }

    public static Appointment[] readDataFromFileToAdditionRow(String filepath) {
        String[] fileData;

        ArrayList<Appointment> appointments;
        try {
            fileData = FileReader.getFileData(filepath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        FileHandler fileHandler = new FileHandler(fileData);
        appointments = fileHandler.getListOfAppointments();

        Appointment[] result = new Appointment[appointments.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = appointments.get(i);
        }

        return result;
    }

}
