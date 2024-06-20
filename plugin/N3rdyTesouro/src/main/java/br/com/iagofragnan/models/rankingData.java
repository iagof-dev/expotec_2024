package br.com.iagofragnan.models;

import java.sql.Date;

public class rankingData {

    private Integer id;
    private String name;
    private Date time_per_round;
    private Date time_per_game;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime_per_round() {
        return time_per_round;
    }

    public void setTime_per_round(Date time_per_round) {
        this.time_per_round = time_per_round;
    }

    public Date getTime_per_game() {
        return time_per_game;
    }

    public void setTime_per_game(Date time_per_game) {
        this.time_per_game = time_per_game;
    }
}
