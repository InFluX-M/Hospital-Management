package com.example.Avabilities;

import com.example.projectta3.Main;

import java.util.ArrayList;

public class DoctorManagerHospital {

    final private ArrayList<Doctor> doctors;

    public ArrayList<Doctor> getDoctors() {
        return this.doctors;
    }

    private int drIndex;

    public int getDrIndex() {
        return drIndex;
    }

    public void setDrIndex(int drIndex) {
        this.drIndex = drIndex;
    }

    public DoctorManagerHospital() {

        doctors = new ArrayList<>();
    }

    public int searchDoctor(String userName, String password) {

        for (int i = 0; i < doctors.size(); i++) {

            if (doctors.get(i).getUserName().equals(userName) && doctors.get(i).getPassword().equals(password))
                return i;
        }

        return -1;
    }

    public Employee searchEmployee(String ID) {

        for (Employee employee : doctors) {

            if (employee.getID().equals(ID)) return employee;
        }

        return null;
    }

    public int searchExistDoctor(String ID) {

        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getID().equals(ID)) return i;
        }

        return -1;
    }

    public int SecretaryExistDr(String doctorID) {

        for (Secretary secretary : Main.myHospital.getSecretaryManager().getSecretaries()) {
            if (secretary.getDoctorID().equals(doctorID)) return 1;
        }
        return -1;
    }

    public void getTurn(String doctorID, String turnNumber, boolean emergency) {

        Turn turn = doctors.get(searchExistDoctor(doctorID)).getSecretary().registerGetTurn(turnNumber);

        turn.setUserName(Main.myHospital.getPatientManager().getPatients().get
                (Main.myHospital.getPatientManager().getPatientIndex()).getUserName());
        turn.setEmergency(emergency);

        Main.myHospital.getPatientManager().getPatients().
                get(Main.myHospital.getPatientManager().getPatientIndex()).getTurns().add(turn);
    }

    public ArrayList<DailyWeekTurn> getFreeTurns(String ID) {

        return this.doctors.get(searchExistDoctor(ID)).getSecretary().freeTurns();
    }

    public void addSecretaryDr(Secretary secretary) {

        doctors.get(drIndex).addSecretary(secretary);
        Main.myHospital.getSecretaryManager().getSecretaries().add(secretary);
        Main.myHospital.getSecretaryManager().getSecretaries().get(Main.myHospital.getSecretaryManager()
                .getSecretaries().size() - 1).registerWeeklyTurns();
    }

    public Turn visitPatient() {

        if (doctors.get(drIndex).getSecretary() != null)
            return doctors.get(drIndex).getSecretary().visitPatient();
        else return null;

    }

    public String visitPatientInformation() {

        if (visitPatient() != null) {

            Patient tempPatient = searchPatientForVisited(visitPatient().getUserName());
            return visitPatient().getTurnNumber() + " " + tempPatient.getFirstName() + tempPatient.getLastName() + " "
                    + tempPatient.getUserName();
        } else return "";

    }

    public Patient searchPatientForVisited(String username) {

        for (int i = 0; i < Main.myHospital.getPatientManager().getPatients().size(); i++)
            if (Main.myHospital.getPatientManager().getPatients().get(i).getUserName().equals(username))
                return Main.myHospital.getPatientManager().getPatients().get(i);

        return null;
    }

    public void givePrescription(Turn lastTurn, ArrayList<String> medicines) {

        String number = String.valueOf(Main.myHospital.getPrescriptions());
        MyDate date = (MyDate) Main.myHospital.getNowDate().clone();

        ArrayList<Medicine> prescriptionsMedicines = new ArrayList<>();
        String doctorID = lastTurn.getDoctorID();
        String patientFileNumber = lastTurn.getUserName();

        for (String medicine : medicines) {
            Medicine tempMed = Main.myHospital.searchMedicine(medicine);

            if (tempMed != null) {
                tempMed.setStock(tempMed.getStock() - 1);
                prescriptionsMedicines.add(tempMed);
            }

        }

        Prescription tempPrescription = new Prescription(number, date, prescriptionsMedicines, doctorID, patientFileNumber);

        Main.myHospital.getPatientManager().getPatients().get(searchPatientForPrescription(lastTurn.getUserName())).givePrescription(tempPrescription);
        doctors.get(drIndex).getSecretary().visitedPatient();
        Main.myHospital.setPrescriptions(Main.myHospital.getPrescriptions() + 1);
    }

    public int searchPatientForPrescription(String fileNumber) {

        for (int i = 0; i < Main.myHospital.getPatientManager().getPatients().size(); i++)
            if (Main.myHospital.getPatientManager().getPatients().get(i).getUserName().equals(fileNumber))
                return i;

        return -1;
    }

    public double dailyPaid() {

        int numberOfRegisteredTurn = 0;

        DailyWeekTurn dailyWeekTurn = doctors.get(drIndex).getSecretary().getWeeklyTurns().
                get(Main.myHospital.getNowDate().dayWeek - 1);

        for (Turn turn : dailyWeekTurn.getDailyTurns()) {

            if (turn.isRegistered()) numberOfRegisteredTurn++;
        }


        return numberOfRegisteredTurn * 15;
    }

    public double monthlyPaidEstimates() {

        ArrayList<DailyWeekTurn> dailyWeekTurns = doctors.get(drIndex).getSecretary().getWeeklyTurns();
        int numberOfRegisteredTurn = 0;

        for (int i = 0; i < Main.myHospital.getNowDate().dayWeek; i++) {

            for (Turn turn : dailyWeekTurns.get(i).getDailyTurns()) {

                if (turn.isRegistered()) numberOfRegisteredTurn++;
            }
        }

        return 30.0 * numberOfRegisteredTurn / (Main.myHospital.getNowDate().dayWeek) * 15;
    }

}
