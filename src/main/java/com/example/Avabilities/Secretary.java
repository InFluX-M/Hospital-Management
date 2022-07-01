package com.example.Avabilities;

import com.example.projectta3.Main;

import java.util.ArrayList;

public class Secretary extends Employee {

    private String doctorID;
    final private ArrayList<Turn> dailyPatientTurns;
    final private ArrayList<DailyWeekTurn> weeklyTurns;
    private Turn lastTurn;

    public Secretary(String firstName, String lastName, String userName, String password, String phoneNumber, String email,
                     String ID, float dailyWorkDutyTime, float hourlyWages, String doctorID) {

        super(firstName, lastName, userName, password, phoneNumber, email, ID, dailyWorkDutyTime, hourlyWages);
        this.doctorID = doctorID;
        this.dailyPatientTurns = new ArrayList<>();
        this.weeklyTurns = new ArrayList<>();
        this.lastTurn = null;
    }


    public String getDoctorID() {
        return doctorID;
    }
    public ArrayList<DailyWeekTurn> getWeeklyTurns() {
        return weeklyTurns;
    }

    public void registerWeeklyTurns() {

        int turnNumber = 1;

        for(int i=1; i<=6; i++) {

            ArrayList<Turn> turns = new ArrayList<>();

            for(int j=0 ; j<10; j++) {

                if(j == 5) continue;
                MyDate startDate = Main.myHospital.getNowDate();
                MyDate turnDate = new MyDate(startDate.year,startDate.month,startDate.day+i-1,8+j,0) ;
                Turn turn = new Turn(Integer.toString(turnNumber), this.doctorID, turnDate);

                turns.add(turn);
                turnNumber++;
            }

            DailyWeekTurn dailyWeekTurn = new DailyWeekTurn(i, turns);

            weeklyTurns.add(dailyWeekTurn);
        }
    }

    public ArrayList<DailyWeekTurn> freeTurns() {

        ArrayList<DailyWeekTurn> freeTurns = new ArrayList<>();

        int i = Main.myHospital.getNowDate().dayWeek;

        for(int j=i-1; j<6; j++) {

            ArrayList<Turn> freeTurn = new ArrayList<>();

            for(Turn turn : weeklyTurns.get(j).getDailyTurns()) {

                if(!turn.isRegistered()) freeTurn.add(turn);
            }

            DailyWeekTurn dailyWeekTurnTemp = new DailyWeekTurn(j+1,freeTurn);
            freeTurns.add(dailyWeekTurnTemp);
        }

        return freeTurns;
    }

    public void dailyTurns() {

        dailyPatientTurns.clear();

        for(Turn turn : weeklyTurns.get(Main.myHospital.getNowDate().dayWeek-1).getDailyTurns()) {

            if(turn.isRegistered()) dailyPatientTurns.add(turn);
        }
    }

    public void setLastTurn() {
        sortDate();

        for(Turn turn : dailyPatientTurns) {

            if(!turn.isVisited())
            {
                this.lastTurn = turn;
                return;
            }
        }
    }

    public Turn visitPatient() {

        setLastTurn();
        return this.lastTurn;
    }

    void sortDate() {

        for(int i=0; i<dailyPatientTurns.size(); i++) {

            for(int j=0; j<dailyPatientTurns.size()-1;j++){

                if(dailyPatientTurns.get(j).compareTo(dailyPatientTurns.get(j+1)) == 1) {

                    Turn tempTurn = dailyPatientTurns.get(j);
                    dailyPatientTurns.remove(j);
                    dailyPatientTurns.add(j+1,tempTurn);
                }

            }
        }
    }

    public Turn registerGetTurn(String turnNumber) {

        for(DailyWeekTurn dailyWeekTurn : weeklyTurns) {

            for(Turn turn : dailyWeekTurn.getDailyTurns()) {

                if(turn.getTurnNumber().equals(turnNumber)){
                    turn.setRegistered(true);
                    if(turn.getTurnTime().dayWeek == Main.myHospital.getNowDate().dayWeek) dailyPatientTurns.add(turn);
                    return turn;
                }
            }
        }

        return null;

    }

    public void visitedPatient() {

        if(lastTurn != null) lastTurn.setVisited(true);
    }

    public void visitedLastTurn() {
        this.lastTurn = null;
    }

}
