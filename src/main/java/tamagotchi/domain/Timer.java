package tamagotchi.domain;

import java.util.concurrent.TimeUnit;

public class Timer {
    private long startTime;

    public Timer() {
        this.startTime = System.nanoTime();
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getCurrentTime() {
        return System.nanoTime();
    }

    public long getTimeElapsed() {
        return this.getCurrentTime() - this.getStartTime();
    }

    public int getTimeElapsedInMinutes() {
        return (int) TimeUnit.NANOSECONDS.toMinutes(this.getTimeElapsed());
    }

}

