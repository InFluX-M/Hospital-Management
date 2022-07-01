package com.example.Avabilities;

import java.util.ArrayList;

public class Custodian extends Employee {

    final private ArrayList<CheckIn_OutEmployee> dailyCheckInTimeEmployee;
    final private ArrayList<CheckIn_OutEmployee> dailyCheckOutTimeEmployee;

    public Custodian(String firstName, String lastName, String userName, String password, String phoneNumber, String email,
                     String ID, float dailyWorkDutyTime, float hourlyWages) {

        super(firstName, lastName, userName, password, phoneNumber, email, ID, dailyWorkDutyTime, hourlyWages);

        this.dailyCheckInTimeEmployee = new ArrayList<>();
        this.dailyCheckOutTimeEmployee = new ArrayList<>();
    }

    public ArrayList<CheckIn_OutEmployee> getDailyCheckInTimeEmployee() {
        return dailyCheckInTimeEmployee;
    }
    public ArrayList<CheckIn_OutEmployee> getDailyCheckOutTimeEmployee() {
        return dailyCheckOutTimeEmployee;
    }

    public void addCheckInTime(CheckIn_OutEmployee checkInTimeEmployee) {

        this.dailyCheckInTimeEmployee.add(checkInTimeEmployee);
    }
    public void addCheckOutTime(CheckIn_OutEmployee checkOutTimeEmployee) {

        this.dailyCheckOutTimeEmployee.add(checkOutTimeEmployee);
    }

}
