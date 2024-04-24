package br.com.iagofragnan.models;

import java.sql.Time;
import java.time.LocalTime;

public class timer {

    private static boolean isRunning = false;
    private static LocalTime startTime;
    private static LocalTime endTime;
    private int timePerRound;
    private java.sql.Time averageTime;

    public static LocalTime getStartTime() {
        return startTime;
    }

    public static void setStartTime(LocalTime newStartTime) {
        startTime = newStartTime;
    }

    public static LocalTime getEndTime() {
        return endTime;
    }

    public static void setEndTime(LocalTime newEndTime) {
        endTime = newEndTime;
    }

    public int getTimePerRound() {
        return timePerRound;
    }

    public void setTimePerRound(int newTimePerRound) {
        timePerRound = newTimePerRound;
    }

    public boolean getIsRunning() {
        return isRunning;
    }

    public static void setIsRunning(boolean newValue) {
        isRunning = newValue;
    }

    public Time getAverageTime() {
        return averageTime;
    }

    public void setAverageTime(Time newAverageTime) {
        averageTime = newAverageTime;
    }
}
