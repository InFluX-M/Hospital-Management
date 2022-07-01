package com.example.Avabilities;

public class CustodianManagerHospital {

    private Custodian custodian;

    public Custodian getCustodian() {
        return custodian;
    }

    public void setCustodian(Custodian custodian) {
        this.custodian = custodian;
    }

    CustodianManagerHospital() {
        custodian = new Custodian("Custodian", "custodian", "cust", "cust", "0",
                "custodian@gmail.com", "10", 24, 20);
    }

    public void addCheckInTime(CheckIn_OutEmployee checkInTimeEmployee) {

        custodian.addCheckInTime(checkInTimeEmployee);
    }

    public void addCheckOutTime(CheckIn_OutEmployee checkOutTimeEmployee) {

        this.custodian.addCheckOutTime(checkOutTimeEmployee);
    }

    public Employee searchEmployee(String ID) {

        if (custodian.getID().equals(ID)) return custodian;

        return null;
    }
}
