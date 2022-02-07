package com.horautc.utc.service;

import java.util.Hashtable;

public class Clock {

    private int hours;
    private int minutes;
    private int seconds;

    private Hashtable <String, Integer> timeData;

    public Clock(Hashtable<String, Integer> timeData){
        hours = timeData.get("hour");
        minutes = timeData.get("minute");
        seconds = timeData.get("second");
        this.timeData = timeData;
    }

    public void incrementsSeconds(int seconds){
        if(seconds >= 0){
            for(int i = 1; i <= seconds; i++){
                this.seconds ++;
                if(this.seconds > 59){
                    this.seconds = 0;
                    incrementsMinutes(1);
                }
            }
        }else{
            for(int i = -1; i >= seconds ; i--){
                this.seconds --;
                if(this.seconds < 0){
                    this.seconds = 59;
                    incrementsMinutes(-1);
                }
            }
        }
    }
    public void incrementsMinutes(int minutes){
        if(minutes >= 0){
            for(int i = 1; i <= minutes; i++){
                this.minutes ++;
                if(this.minutes > 59){
                    this.minutes = 0;
                    incrementsHours(1);
                }
            }
        }else{
            for(int i = -1; i >= minutes; i--){
                this.minutes --;
                if(this.minutes < 0){
                    this.minutes = 59;
                    incrementsHours(-1);
                }
            }
        }

    }
    public void incrementsHours(int hours){
        if(hours >= 0){
            for(int i = 1; i<= hours; i++){
                this.hours++;
                if(this.hours > 23)
                    this.hours = 0;
            }
        }else{
            for(int i = -1; i >= hours; i--){
                this.hours--;
                if(this.hours < 0)
                    this.hours = 23;
            }
        }
    }

    public String getTime(){
        String hh = (hours<10)?"0"+hours: String.valueOf(hours);
        String mm = (minutes<10)?"0"+minutes: String.valueOf(minutes);
        String ss = (seconds<10)?"0"+seconds: String.valueOf(seconds);
        return hh+":"+mm+":"+ss;
    }

    public Hashtable<String, Integer> hetTimeData(){
        timeData.put("hour", hours);
        timeData.put("minute", minutes);
        timeData.put("second", seconds);
        return timeData;
    }

}
