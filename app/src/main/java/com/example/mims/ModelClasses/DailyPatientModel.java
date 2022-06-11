package com.example.mims.ModelClasses;

public class DailyPatientModel {
    int Saturday;
    int Sunday;
    int Monday;
    int Tuesday;
    int Thursday;
    int Wednesday;
    int Friday;

    public DailyPatientModel() {
    }

    public DailyPatientModel(int saturday, int sunday,
                             int monday, int tuesday, int thursday, int wednesday, int friday) {
        Saturday = saturday;
        Sunday = sunday;
        Monday = monday;
        Tuesday = tuesday;
        Thursday = thursday;
        Wednesday = wednesday;
        Friday = friday;
    }

    public int getSaturday() {
        return Saturday;
    }

    public void setSaturday(int saturday) {
        Saturday = saturday;
    }

    public int getSunday() {
        return Sunday;
    }

    public void setSunday(int sunday) {
        Sunday = sunday;
    }

    public int getMonday() {
        return Monday;
    }

    public void setMonday(int monday) {
        Monday = monday;
    }

    public int getTuesday() {
        return Tuesday;
    }

    public void setTuesday(int tuesday) {
        Tuesday = tuesday;
    }

    public int getThursday() {
        return Thursday;
    }

    public void setThursday(int thursday) {
        Thursday = thursday;
    }

    public int getWednesday() {
        return Wednesday;
    }

    public void setWednesday(int wednesday) {
        Wednesday = wednesday;
    }

    public int getFriday() {
        return Friday;
    }

    public void setFriday(int friday) {
        Friday = friday;
    }
}
