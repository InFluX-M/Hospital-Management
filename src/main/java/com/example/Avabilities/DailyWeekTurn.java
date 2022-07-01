package com.example.Avabilities;

import java.util.ArrayList;

public class DailyWeekTurn {

    final private int day;
    final private ArrayList<Turn> dailyTurns;

    DailyWeekTurn(int day, ArrayList<Turn> dailyTurns) {

        this.day = day;
        this.dailyTurns = dailyTurns;
    }

    public int getDay() {
        return day;
    }
    public ArrayList<Turn> getDailyTurns() {
        return dailyTurns;
    }
}
