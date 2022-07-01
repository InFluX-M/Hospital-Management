package com.example.Avabilities;

public class Turn implements Comparable {

    final private String turnNumber;
    private String userName;
    final private String doctorID;
    final private MyDate turnTime;
    private boolean visited;
    private boolean emergency;
    private boolean registered;

    Turn(String turnNumber, String doctorID, MyDate turnTime) {

        this.turnNumber = turnNumber;
        this.doctorID = doctorID;
        this.turnTime = turnTime;
        this.visited = false;
        this.emergency = false;
        this.registered = false;
    }

    public String getTurnNumber() {return this.turnNumber;}
    public String getUserName() {return this.userName;}
    public String getDoctorID() {return this.doctorID;}
    public MyDate getTurnTime() {return this.turnTime;}
    public boolean isVisited() {return this.visited;}
    public boolean isEmergency() {return this.emergency;}
    public boolean isRegistered() {return registered;}

    public void setRegistered(boolean registered) {this.registered = registered;}
    public void setVisited(boolean visited) {this.visited = visited;}
    public void setEmergency(boolean emergency) {this.emergency = emergency;}
    public void setUserName(String patientFileNumber) {this.userName = patientFileNumber;}

    @Override
    public int compareTo(Object object) {

        if(this.emergency && !((Turn)object).emergency) return -1;
        if(!this.emergency && ((Turn)object).emergency) return 1;

        if(Integer.parseInt(this.turnNumber) < Integer.parseInt(((Turn)object).turnNumber)) return -1;
        if(Integer.parseInt(this.turnNumber) > Integer.parseInt(((Turn)object).turnNumber)) return 1;

        return 0;
    }
}