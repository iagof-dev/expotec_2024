package br.com.iagofragnan.models;

import java.sql.Time;
import java.time.LocalTime;

public class timer {

    private static boolean isRunning = false;
    private static LocalTime startTime;
    private static LocalTime endTime;

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




    public boolean getIsRunning() {
        return isRunning;
    }

    public static void setIsRunning(boolean newValue) {
        isRunning = newValue;
    }

}
