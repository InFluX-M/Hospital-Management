package com.example.Avabilities;

public class Doctor extends Employee {

    final private String speciality;
    private String biography;
    private Secretary secretary;

    public Doctor(String firstName, String lastName, String userName, String password, String phoneNumber, String email,
                  String ID, float dailyWorkDutyTime, float hourlyWages, String speciality, String biography) {

        super(firstName, lastName, userName, password, phoneNumber, email, ID, dailyWorkDutyTime, hourlyWages);
        this.speciality = speciality;
        this.biography = biography;
        this.secretary = null;
    }

    public String getSpeciality() {return this.speciality;}
    public Secretary getSecretary() {return this.secretary;}

    void addSecretary(Secretary tempSec) {

        this.secretary = tempSec;
    }

}
