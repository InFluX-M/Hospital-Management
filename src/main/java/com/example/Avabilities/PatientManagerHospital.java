package com.example.Avabilities;

import java.util.ArrayList;

public class PatientManagerHospital {

    final private ArrayList<Patient> patients;

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    private int patientIndex;

    public int getPatientIndex() {
        return patientIndex;
    }

    public void setPatientIndex(int patientIndex) {
        this.patientIndex = patientIndex;
    }

    PatientManagerHospital() {

        patients = new ArrayList<>();
    }

    public ArrayList<Turn> historyTurnsPatient() {
        return patients.get(patientIndex).getTurns();
    }

    public ArrayList<Prescription> historyPrescriptionsPatient() {
        return patients.get(patientIndex).getPrescriptions();
    }

    public boolean availableUserName(String userName) {

        for (Patient patient : patients) {
            if (userName.equals(patient.getUserName())) return false;
        }

        return true;
    }

    public void addPatient(Patient patient) {

        this.patients.add(patient);
    }

    public int searchPatient(String userName, String password) {

        for (int i = 0; i < patients.size(); i++) {

            if (patients.get(i).getUserName().equals(userName) && patients.get(i).getPassword().equals(password))
                return i;
        }

        return -1;
    }

    public void editInformationPatient(String fieldInformation, String newInformation) {

        patients.get(patientIndex).editInformation(fieldInformation, newInformation);
    }

    public String patientInformation() {

        return this.patients.get(patientIndex).getUserName() + " " +
                this.patients.get(patientIndex).getFirstName() + this.patients.get(patientIndex).getLastName() + " " +
                this.patients.get(patientIndex).getPassword() + " " + this.patients.get(patientIndex).getPhoneNumber() +
                " " + this.patients.get(patientIndex).getEmail();
    }

}
