package com.example.Avabilities;

import java.util.ArrayList;

abstract public class Employee extends User{

   final private String ID;
   private float monthlyWorkTime;
   private int workWeek;
   private float dailyWorkDutyTime;
   private float hourlyWages;
   private int numberOfWeeklyAbsences;
   private boolean suspension;
   private ArrayList<MyDate> businessDates;
   private MonthlyPaid monthlyPaid;
   private int attendanceTime;

    public Employee(String firstName, String lastName, String userName, String password, String phoneNumber, String email,
                    String ID, float dailyWorkDutyTime, float hourlyWages) {

        super(firstName, lastName, userName, password, phoneNumber, email);

        this.ID = ID;
        this.dailyWorkDutyTime = dailyWorkDutyTime;
        this.hourlyWages = hourlyWages;
        this.suspension = false;
        this.businessDates = new ArrayList<>();
        this.monthlyPaid = new MonthlyPaid(hourlyWages*dailyWorkDutyTime*30 , false);
        this.attendanceTime = 0;
    }

    public int getAttendanceTime() {
        return attendanceTime;
    }

    public void setAttendanceTime(int attendanceTime) {
        this.attendanceTime = attendanceTime;
    }

    public String getID() {
        return ID;
    }

    public float getDailyWorkDutyTime() {
        return dailyWorkDutyTime;
    }
    public float getHourlyWages() {
        return hourlyWages;
    }

    public int getNumberOfWeeklyAbsences() {
        return numberOfWeeklyAbsences;
    }
    public void setNumberOfWeeklyAbsences(int numberOfWeeklyAbsences) {
        this.numberOfWeeklyAbsences = numberOfWeeklyAbsences;
    }

    public boolean isSuspension() {
        return suspension;
    }

    public void setSuspension(boolean suspension) {
        this.suspension = suspension;
    }

    public ArrayList<MyDate> getBusinessDates() {
        return businessDates;
    }

    public void setMonthlyPaid() {

        this.monthlyPaid.setMonthlyIncome(this.dailyWorkDutyTime * this.hourlyWages * 30);
    }

    public MonthlyPaid getPaid() {
        return this.monthlyPaid;

    }

    public void registerGetPaid() {
        this.monthlyPaid.setCheckout(true);
    }
}
