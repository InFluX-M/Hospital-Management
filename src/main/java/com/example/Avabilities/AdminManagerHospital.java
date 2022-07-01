package com.example.Avabilities;

import com.example.projectta3.Main;

import java.util.ArrayList;

public class AdminManagerHospital {

    final private Admin admin;

    public Admin getAdmin() {
        return admin;
    }

    AdminManagerHospital() {

        admin = new Admin("admin", "admin");
    }

    public void changeDay() {
        Main.myHospital.nextDay();
    }

    public void addMedicine(Medicine tempMed) {

        Main.myHospital.getMedicines().add(tempMed);
    }

    public void addDoctor(Doctor doctor) {

        Main.myHospital.getDoctorManager().getDoctors().add(doctor);
    }

    public void addServant(Servant servant) {

        Main.myHospital.getServantManager().getServants().add(servant);
    }

    public void addCustodian(Custodian custodian) {

        Main.myHospital.getCustodianManager().setCustodian(custodian);
    }

    public ArrayList<Equipment> getEquipmentRequests() {
        return Main.myHospital.getServantManager().getEquipments();
    }

    public void checkEquipmentRequests(int indexReq, boolean verification) {

        Main.myHospital.getServantManager().getEquipments().get(indexReq - 1).verification = verification;
        Main.myHospital.getServantManager().getEquipments().get(indexReq - 1).checked = true;
        Main.myHospital.getServantManager().getEquipments().remove(Main.myHospital.getServantManager().getEquipments().get(indexReq - 1));
    }

    public ArrayList<Crash> getCrashReports() {
        return Main.myHospital.getServantManager().getCrashes();
    }

    public void checkCrashReports(int indexReq, boolean confirmation) {

        Main.myHospital.getServantManager().getCrashes().get(indexReq - 1).confirmation = confirmation;
        Main.myHospital.getServantManager().getCrashes().get(indexReq - 1).checked = true;
        Main.myHospital.getServantManager().getCrashes().remove(Main.myHospital.getServantManager().getCrashes().get(indexReq - 1));

    }

    public ArrayList<Doctor> listSuspensionOfDoctor() {

        ArrayList<Doctor> doctors = new ArrayList<>();
        for (Doctor doctor : Main.myHospital.getDoctorManager().getDoctors()) {

            if (doctor.getNumberOfWeeklyAbsences() >= 2) doctors.add(doctor);
        }

        return doctors;
    }

    public ArrayList<Servant> listSuspensionOfServant() {

        ArrayList<Servant> servants = new ArrayList<>();
        for (Servant servant : Main.myHospital.getServantManager().getServants()) {

            if (servant.getNumberOfWeeklyAbsences() >= 2) servants.add(servant);
        }

        return servants;
    }

    public ArrayList<Secretary> listSuspensionOfSecretary() {

        ArrayList<Secretary> secretaries = new ArrayList<>();
        for (Doctor doctor : Main.myHospital.getDoctorManager().getDoctors()) {

            if (doctor.getSecretary() != null) {
                if (doctor.getSecretary().getNumberOfWeeklyAbsences() >= 2) secretaries.add(doctor.getSecretary());

            }
        }

        return secretaries;
    }

    public void registerSuspensionOfDoctor(Doctor doctor) {
        doctor.setSuspension(true);
    }

    public void registerSuspensionOfServant(Servant servant) {
        servant.setSuspension(true);
    }

    public void registerSuspensionOfSecretary(Secretary secretary) {
        secretary.setSuspension(true);
    }
}
