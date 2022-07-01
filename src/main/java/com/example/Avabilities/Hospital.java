package com.example.Avabilities;

import com.example.projectta3.Main;

import java.util.ArrayList;

public class Hospital {

    private MyDate nowDate = new MyDate();

    public MyDate getNowDate() {
        return nowDate;
    }
    public void nextDay() {

        MyDate nextDay;

        if(nowDate.dayWeek != 7) {
            setMonthlyPaid();
            calculateAttendanceStatue();

            if(nowDate.dayWeek == 7)
                for(Secretary secretary : Main.myHospital.getSecretaryManager().getSecretaries())
                    secretary.registerWeeklyTurns();
        }

        if(nowDate.day == 30) {

            for(Doctor doctor : Main.myHospital.getDoctorManager().getDoctors()) {
                doctor.getPaid().setCheckout(false);
            }

            for(Servant servant : Main.myHospital.getServantManager().getServants()) {
                servant.getPaid().setCheckout(false);
            }

            for(Secretary secretary : Main.myHospital.getSecretaryManager().getSecretaries()) {
                secretary.getPaid().setCheckout(false);
            }

            Main.myHospital.getCustodianManager().getCustodian().getPaid().setCheckout(false);

            if(nowDate.month == 12)
                nextDay = new MyDate(nowDate.year+1, 1, 1, 0,0);
            else
                nextDay = new MyDate(nowDate.year, nowDate.month+1, 1, 0,0);

        }
        else nextDay = new MyDate(nowDate.year, nowDate.month, nowDate.day+1, 0,0);


        if(nowDate.dayWeek == 1)
            custodianManager.getCustodian().getDailyCheckOutTimeEmployee().clear();
        else {
            custodianManager.getCustodian().getDailyCheckOutTimeEmployee().clear();
            custodianManager.getCustodian().getDailyCheckInTimeEmployee().clear();
        }

        nowDate = nextDay;

        if(nowDate.dayWeek != 6 && nowDate.dayWeek != 7) {
            for(Secretary secretary : Main.myHospital.getSecretaryManager().getSecretaries())
                secretary.dailyTurns();
        }


    }

    public void setMonthlyPaid() {

        for(Doctor doctor : Main.myHospital.getDoctorManager().getDoctors()) {
            doctor.setMonthlyPaid();
        }

        for(Servant servant : Main.myHospital.getServantManager().getServants()) {
            servant.setMonthlyPaid();
        }

        for(Secretary secretary : Main.myHospital.getSecretaryManager().getSecretaries()) {
            secretary.setMonthlyPaid();
        }

        Main.myHospital.getCustodianManager().getCustodian().setMonthlyPaid();
    }

    final private AdminManagerHospital adminManager;
    final private DoctorManagerHospital doctorManager;
    final private PatientManagerHospital patientManager;
    final private SecretaryManagerHospital secretaryManager;
    final private ServantManagerHospital servantManager;
    final private CustodianManagerHospital custodianManager;

    final private ArrayList<Medicine> medicines;
    private int prescriptions;

    public Hospital() {

        adminManager = new AdminManagerHospital();
        doctorManager = new DoctorManagerHospital();
        patientManager = new PatientManagerHospital();
        secretaryManager = new SecretaryManagerHospital();
        servantManager = new ServantManagerHospital();
        custodianManager = new CustodianManagerHospital();

        medicines = new ArrayList<>();
        prescriptions = 0;
    }

    public AdminManagerHospital getAdminManager() {
        return adminManager;
    }
    public DoctorManagerHospital getDoctorManager() {
        return doctorManager;
    }
    public PatientManagerHospital getPatientManager() {
        return patientManager;
    }
    public SecretaryManagerHospital getSecretaryManager() {
        return secretaryManager;
    }
    public ServantManagerHospital getServantManager() {
        return servantManager;
    }
    public CustodianManagerHospital getCustodianManager() {
        return custodianManager;
    }

    public ArrayList<Medicine> getMedicines() {
        return this.medicines;
    }
    public int getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(int prescriptions) {
        this.prescriptions = prescriptions;
    }

    public int login(String username, String password, String rule) {

        switch (rule) {

            case "Admin":
                if(username.equals(adminManager.getAdmin().getUserName()) && password.equals(adminManager.getAdmin().getPassword())) {
                    return 0;
                }
                else return -1;

            case "Doctor":
                int m = doctorManager.searchDoctor(username, password);

                if(m > -1) {

                    if(doctorManager.getDoctors().get(m).isSuspension()) {
                        return 15;
                    }
                    else {
                        doctorManager.setDrIndex(m);
                        return 1;
                    }

                }
                else return -1;

            case "Patient":
                int n = patientManager.searchPatient(username, password);

                if(n > -1) {

                    patientManager.setPatientIndex(n);
                    return 2;
                }
                else return -1;

            case "Secretary":

                int i = secretaryManager.searchSecretary(username, password);

                if(i > -1) {

                    if(secretaryManager.getSecretaries().get(i).isSuspension()) {
                        return 15;
                    }
                    else {
                        secretaryManager.setSecretaryIndex(i);
                        return 3;
                    }

                }
                else return -1;

            case "Servant":

                int j = servantManager.searchServant(username, password);

                if(j > -1) {

                    if(servantManager.getServants().get(j).isSuspension()) {
                        return 15;
                    }
                    else {
                        servantManager.setServantIndex(j);
                        return 4;
                    }
                }
                else return -1;

            case "Custodian":

                if(username.equals(custodianManager.getCustodian().getUserName()) &&
                        password.equals(custodianManager.getCustodian().getPassword())) {

                    if(custodianManager.getCustodian().isSuspension()) {
                        return 15;
                    }
                    else {
                        return 5;
                    }

                }
                else return -1;

            default:
                return -1;
        }

    }

    public Employee searchEmployee(String ID) {

        if(doctorManager.searchEmployee(ID) != null) return doctorManager.searchEmployee(ID);
        else if(secretaryManager.searchEmployee(ID) != null) return secretaryManager.searchEmployee(ID);
        else if(servantManager.searchEmployee(ID) != null) return servantManager.searchEmployee(ID);
        else if(custodianManager.searchEmployee(ID) != null) return custodianManager.searchEmployee(ID);

        return null;
    }

    public void calculateAttendanceStatue() {

        ArrayList<CheckIn_OutEmployee> dailyCheckInTimeEmployee = custodianManager.getCustodian().getDailyCheckInTimeEmployee();
        ArrayList<CheckIn_OutEmployee> dailyCheckOutTimeEmployee = custodianManager.getCustodian().getDailyCheckOutTimeEmployee();

        for (CheckIn_OutEmployee checkInOutEmployee : dailyCheckInTimeEmployee) {

            for (CheckIn_OutEmployee checkIn_outEmployee : dailyCheckOutTimeEmployee) {

                if (checkInOutEmployee.ID.equals(checkIn_outEmployee.ID)) {

                    Employee employee = Main.myHospital.searchEmployee(checkInOutEmployee.ID);
                    employee.setAttendanceTime(checkIn_outEmployee.time.differenceToHour(checkInOutEmployee.time));

                }
            }
        }

        for(Doctor doctor : doctorManager.getDoctors()) {

            if(doctor.getAttendanceTime() < doctor.getDailyWorkDutyTime()) doctor.setNumberOfWeeklyAbsences(doctor.getNumberOfWeeklyAbsences()+1);
            else doctor.getBusinessDates().add(nowDate);

            doctor.setAttendanceTime(0);
        }
        for(Secretary secretary : secretaryManager.getSecretaries()) {

            if(secretary.getAttendanceTime() < secretary.getDailyWorkDutyTime()) secretary.setNumberOfWeeklyAbsences(secretary.getNumberOfWeeklyAbsences()+1);
            else secretary.getBusinessDates().add(nowDate);

            secretary.setAttendanceTime(0);

        }
        for(Servant servant : servantManager.getServants()) {

            if(servant.getAttendanceTime() < servant.getDailyWorkDutyTime()) servant.setNumberOfWeeklyAbsences(servant.getNumberOfWeeklyAbsences()+1);
            else servant.getBusinessDates().add(nowDate);

            servant.setAttendanceTime(0);
        }

        custodianManager.getCustodian().getBusinessDates().add(nowDate);

        custodianManager.getCustodian().getDailyCheckInTimeEmployee().clear();
        custodianManager.getCustodian().getDailyCheckOutTimeEmployee().clear();

    }

    public Medicine searchMedicine(String name) {

        for (Medicine medicine : this.medicines)
            if (medicine.getName().equals(name))
                return medicine;

        return null;
    }

}


