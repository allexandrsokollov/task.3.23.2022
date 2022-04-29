package vsu.cs.sokolov.entities;

public class Timer implements Runnable {
    private int time;
    private int delay;

    public Timer(int delay) {
        this.time = 0;
        this.delay = delay;

    }

    @Override
    public void run() {

    }
}
