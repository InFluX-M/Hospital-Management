package com.example.Avabilities;

import java.util.ArrayList;

public class Patient extends User {

    final private ArrayList<Prescription> prescriptions;
    final private ArrayList<Turn> turns;

    public Patient(String username, String firstName, String lastName, String password, String phoneNumber, String email) {

        super(firstName, lastName, username, password, phoneNumber, email);
        this.prescriptions = new ArrayList<>();
        this.turns = new ArrayList<>();
    }

    public ArrayList<Prescription> getPrescriptions() {return this.prescriptions;}
    public ArrayList<Turn> getTurns() {return this.turns;}

    void editInformation(String fieldInformation, String newInformation) {

        switch (fieldInformation) {

            case "name":

                String name[] = newInformation.split(" ");

                setFirstName(name[0]);
                setLastName(name[1]);
                break;

            case "password":
                setPassword(newInformation);
                break;

            case "phoneNumber":
                setPhoneNumber(newInformation);
                break;

            case "email":
                setEmail(newInformation);
                break;
        }

    }

    void givePrescription(Prescription tempPrescription) {

        this.prescriptions.add(tempPrescription);
    }

}