package com.horautc.utc;

import com.horautc.utc.service.Clock;
import com.horautc.utc.service.Tools;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UTCTest {

    String time;
    String timezone;

    @Test
    void isValidEnteredData() {
        time = "21:10:59";
        timezone = "-3";
        assertEquals(Tools.isDataValid(Tools.getDataTime(time, ':'), timezone), true);
    }

    @Test
    void invalidEnteredData() {
        time = "21:10:6G";
        timezone = "-3";
        assertEquals(Tools.isDataValid(Tools.getDataTime(time, ':'), timezone), false);
    }

    @Test
    void invalidHourData() {
        time = "24:00:45"; // 24 no existe
        timezone = "-3";
        assertEquals(Tools.isDataValid(Tools.getDataTime(time, ':'), timezone), false);
    }

    @Test
    void invalidMinuteData() {
        time = "21:100:45";
        timezone = "-3";
        assertEquals(Tools.isDataValid(Tools.getDataTime(time, ':'), timezone), false);
    }

    @Test
    void invalidSecondData() {
        time = "21:10:60";
        timezone = "-3";
        assertEquals(Tools.isDataValid(Tools.getDataTime(time, ':'), timezone), false);
    }

    @Test
    void invalidTimezoneNumber() {
        time = "21:10:60";
        timezone = "-21";
        assertEquals(Tools.isDataValid(Tools.getDataTime(time, ':'), timezone), false);
    }

    @Test
    void invalidTimezoneAlfa() {
        time = "21:10:60";
        timezone = "zzz";
        assertEquals(Tools.isDataValid(Tools.getDataTime(time, ':'), timezone), false);
    }

    @Test
    void invalidTimeAlfa() {
        time = "21:10:6G";
        timezone = "-3";
        assertEquals(Tools.isDataValid(Tools.getDataTime(time, ':'), timezone), false);
    }

    @Test
    void isHourNumber(){
        time = "12:45:00";
        assertEquals(Tools.getDataTime(time, ':').get("hour"), 12);
    }
    @Test
    void isMinuteNumber(){
        time = "12:45:00";
        assertEquals(Tools.getDataTime(time, ':').get("minute"), 45);
    }

    @Test
    void isSecondNumber(){
        time = "12:45:00";
        assertEquals(Tools.getDataTime(time, ':').get("second"), 0);
    }

    @Test
    void correctHourIncrement(){
        time = "23:59:06";
        Clock clock = new Clock(Tools.getDataTime(time, ':'));
        clock.incrementsHours(1);
        assertEquals(clock.getTime(), "00:59:06");
    }

    //A continuación, el incremento del tiempo en la clase Clock es independiente de la
    // validación de las zonas horarias (Tools.isDataValid)

    @Test
    void correctHourDecrement(){
        time = "23:59:06";
        Clock clock = new Clock(Tools.getDataTime(time, ':'));
        clock.incrementsHours(-1);
        assertEquals(clock.getTime(), "22:59:06");
    }

    @Test
    void correctMinuteIncrement(){
        time = "23:59:06";
        Clock clock = new Clock(Tools.getDataTime(time, ':'));
        clock.incrementsMinutes(1);
        assertEquals(clock.getTime(), "00:00:06");
    }

    @Test
    void correctMinuteDecrement(){
        time = "23:59:06";
        Clock clock = new Clock(Tools.getDataTime(time, ':'));
        clock.incrementsMinutes(-1);
        assertEquals(clock.getTime(), "23:58:06");
    }

    @Test
    void correctSecondIncrement(){
        time = "23:59:59";
        Clock clock = new Clock(Tools.getDataTime(time, ':'));
        clock.incrementsSeconds(6);
        assertEquals(clock.getTime(), "00:00:05");
    }

    @Test
    void correctSecondDecrement(){
        time = "23:59:59";
        Clock clock = new Clock(Tools.getDataTime(time, ':'));
        clock.incrementsSeconds(-6);
        assertEquals(clock.getTime(), "23:59:53");
    }

}