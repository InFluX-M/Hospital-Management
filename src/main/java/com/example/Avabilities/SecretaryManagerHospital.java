package com.example.Avabilities;

import java.util.ArrayList;

public class SecretaryManagerHospital {

    final private ArrayList<Secretary> secretaries;

    public ArrayList<Secretary> getSecretaries() {
        return secretaries;
    }

    private int secretaryIndex;

    public int getSecretaryIndex() {
        return secretaryIndex;
    }

    public void setSecretaryIndex(int secretaryIndex) {
        this.secretaryIndex = secretaryIndex;
    }

    public SecretaryManagerHospital() {
        this.secretaries = new ArrayList<>();
    }

    public int searchSecretary(String userName, String password) {

        for (int i = 0; i < secretaries.size(); i++) {

            if (secretaries.get(i).getUserName().equals(userName) && secretaries.get(i).getPassword().equals(password))
                return i;
        }

        return -1;
    }

    public Employee searchEmployee(String ID) {

        for (Employee employee : secretaries)
            if (employee.getID().equals(ID)) return employee;

        return null;
    }

    public ArrayList<Turn> turnRegistered() {

        ArrayList<Turn> turnRegistered = new ArrayList<>();

        for (DailyWeekTurn weekTurn : secretaries.get(secretaryIndex).getWeeklyTurns())
            for (Turn turn : weekTurn.getDailyTurns())
                if (turn.isRegistered()) turnRegistered.add(turn);

        return turnRegistered;
    }

}
