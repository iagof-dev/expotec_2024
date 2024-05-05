package br.com.iagofragnan.models;

import java.time.LocalTime;
import java.util.HashMap;

public class ranking {


    private String name;
    private LocalTime time;
    private LocalTime avgTime;


    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime newTime) {
        time = newTime;
    }

    public LocalTime getAvgTime() {
        return avgTime;
    }

    public void setAvgTime(LocalTime newAvgTime) {
        avgTime = newAvgTime;
    }
}
