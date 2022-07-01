package com.example.Avabilities;

public class MyDate implements Comparable {

    enum DailyWeek {
        SATURDAY, SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
    }
    enum Monthly {
        JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
    }

    public static final int BASE_YEAR = 2022;
    public static final int BASE_MONTH = 1;
    public static final int BASE_DAY = 1;
    public static final MyDate BASE_DATE = new MyDate();

    final public int year;
    final public int month;
    final public int day;
    final public int hour;
    final public int minute;
    final public int dayWeek;
    final public DailyWeek dailyWeek;
    final public Monthly monthly;

    public MyDate() {
        this.year = BASE_YEAR;
        this.month = BASE_MONTH;
        this.day = BASE_DAY;
        this.hour = 0;
        this.minute = 0;
        this.dayWeek = 1;
        this.dailyWeek = DailyWeek.SATURDAY;
        this.monthly = Monthly.JANUARY;
    }

    public MyDate(int year,int month,int day) {

        this.year = year;
        this.month = month;
        this.monthly = monthly();
        this.day = day;
        this.dayWeek = (differenceToDay(BASE_DATE) % 7) + 1;
        this.dailyWeek = dailyWeek();
        this.hour = 0;
        this.minute = 0;
    }

    public MyDate(int year, int month, int day, int hour, int minute) {

        this.year = year;
        this.month = month;
        this.monthly = monthly();
        this.day = day;
        this.dayWeek = (differenceToDay(BASE_DATE) % 7) + 1;
        this.dailyWeek = dailyWeek();
        this.hour = hour;
        this.minute = minute;
    }

    @Override
    public int compareTo(Object o) {

        if(this.year > ((MyDate)o).year) return 1;
        if(this.year < ((MyDate)o).year) return -1;

        if(this.month > ((MyDate)o).month) return 1;
        if(this.month < ((MyDate)o).month) return -1;

        if(this.day > ((MyDate)o).day) return 1;
        if(this.day < ((MyDate)o).day) return -1;

        if(this.hour > ((MyDate)o).hour) return 1;
        if(this.hour < ((MyDate)o).hour) return -1;

        if(this.minute > ((MyDate)o).minute) return 1;
        if(this.minute < ((MyDate)o).minute) return -1;

        return 0;
    }

    public int differenceToDay(MyDate date) {

        return (this.year - date.year) * 360 + (this.month - date.month) * 30 + (this.day - date.day);
    }

    public int differenceToHour(MyDate date) {

        return differenceToDay(date)*24 + (this.hour - date.hour) + (((this.minute - date.minute) > 30) ? 1:0);
    }

    public int differenceToMinute(MyDate date) {

        return differenceToHour(date)*60;
    }

    public DailyWeek dailyWeek() {

        switch(this.dayWeek) {

            case 1: return DailyWeek.SATURDAY;
            case 2: return DailyWeek.SUNDAY;
            case 3: return DailyWeek.MONDAY;
            case 4: return DailyWeek.TUESDAY;
            case 5: return DailyWeek.WEDNESDAY;
            case 6: return DailyWeek.THURSDAY;
            case 7: return DailyWeek.FRIDAY;

        }

        return null;
    }

    public Monthly monthly() {

        switch(this.month) {

            case 1: return Monthly.JANUARY;
            case 2: return Monthly.FEBRUARY;
            case 3: return Monthly.MARCH;
            case 4: return Monthly.APRIL;
            case 5: return Monthly.MAY;
            case 6: return Monthly.JUNE;
            case 7: return Monthly.JULY;
            case 8: return Monthly.AUGUST;
            case 9: return Monthly.SEPTEMBER;
            case 10: return Monthly.OCTOBER;
            case 11: return Monthly.NOVEMBER;
            case 12: return Monthly.DECEMBER;

        }

        return null;
    }

    @Override
    public String toString() {

        return this.dailyWeek + " " + ((this.hour/10 == 0) ? "0"+this.hour : this.hour) + ":" +
                ((this.minute/10 == 0) ? "0"+this.minute : this.minute) + " " + this.day + " " +
                this.monthly + " " + this.year;
    }

    public String toString(boolean statue) {

        return this.day + " " + this.monthly + " " + this.year;
    }

    @Override
    public Object clone() {

        MyDate cloneDate = new MyDate(this.year,this.month,this.day,this.hour,this.minute);
        return cloneDate;
    }

}
