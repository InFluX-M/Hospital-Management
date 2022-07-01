package com.example.Avabilities;

import java.util.ArrayList;

public class Servant extends Employee {

    ArrayList<Crash> hospitalCrash;
    ArrayList<Equipment> hospitalEquipmentsRequest;

    public Servant(String firstName, String lastName, String userName, String password, String phoneNumber, String email, String ID,
                   float dailyWorkDutyTime, float hourlyWages) {

        super(firstName, lastName, userName, password, phoneNumber, email, ID, dailyWorkDutyTime, hourlyWages);

        this.hospitalCrash = new ArrayList<>();
        this.hospitalEquipmentsRequest = new ArrayList<>();
    }

    public void crashReport(Crash crash) {
        this.hospitalCrash.add(crash);
    }

    public void equipmentsRequest(Equipment equipment) { this.hospitalEquipmentsRequest.add(equipment); }

}