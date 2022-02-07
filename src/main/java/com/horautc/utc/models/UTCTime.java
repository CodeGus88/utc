package com.horautc.utc.models;


public class UTCTime {

    private String time;
    private String timezone;

    // El tiempo universal coordinado o UTC
    public UTCTime(){
        time = "00:00:00";
        timezone = "utc";
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @Override
    public String toString() {
        return "UTCTime{" +
                "time='" + time + '\'' +
                ", timezone='" + timezone + '\'' +
                '}';
    }

}
