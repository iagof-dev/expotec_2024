<<<<<<< HEAD
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
=======
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
>>>>>>> 1b13af6f01d7e8715a26ffe1599171301399c2db
