package com.example.Avabilities;

import java.util.ArrayList;

public class Prescription {

    final private String number;
    final private MyDate date;
    final private ArrayList<Medicine> medicines;
    final private String doctorID;
    final private String patientFileNumber;

    Prescription(String number, MyDate date, ArrayList<Medicine> medicines, String doctorID, String patientFileNumber) {

        this.number = number;
        this.date = date;
        this.medicines = medicines;
        this.doctorID = doctorID;
        this.patientFileNumber = patientFileNumber;

    }

    public String getNumber() {return number;}
    public MyDate getDate() {return date;}
    public String getDoctorID() {return doctorID;}
    public ArrayList<Medicine> getMedicines() {return medicines;}
    public String getPatientFileNumber() {
        return patientFileNumber;
    }
}