package com.example.Avabilities;

import java.util.ArrayList;

public class ServantManagerHospital {

    final private ArrayList<Servant> servants;

    public ArrayList<Servant> getServants() {
        return servants;
    }

    final private ArrayList<Crash> crashes;

    public ArrayList<Crash> getCrashes() {
        return crashes;
    }

    final private ArrayList<Equipment> equipments;

    public ArrayList<Equipment> getEquipments() {
        return equipments;
    }

    private int servantIndex;

    public int getServantIndex() {
        return servantIndex;
    }

    public void setServantIndex(int servantIndex) {
        this.servantIndex = servantIndex;
    }

    public ServantManagerHospital() {

        this.servants = new ArrayList<>();
        this.crashes = new ArrayList<>();
        this.equipments = new ArrayList<>();
    }

    public int searchServant(String userName, String password) {

        for (int i = 0; i < servants.size(); i++) {

            if (servants.get(i).getUserName().equals(userName) && servants.get(i).getPassword().equals(password))
                return i;
        }

        return -1;
    }

    public void addCrashReport(Crash crash) {

        servants.get(servantIndex).crashReport(crash);
        crashes.add(crash);
    }

    public void addEquipmentRequest(Equipment equipment) {

        servants.get(servantIndex).equipmentsRequest(equipment);
        equipments.add(equipment);
    }

    public Employee searchEmployee(String ID) {

        for (Employee employee : servants) {

            if (employee.getID().equals(ID)) return employee;
        }

        return null;
    }
}
