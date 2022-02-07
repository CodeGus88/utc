package com.horautc.utc.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

/**
 * Esta clase contiene atributos (hard code), y métodos como funciones státicos
 *
 */
public class Tools {

    // Hace referencia a las diferentes zonas horarias que existen en el mundo
    public static ArrayList<String> TIMEZONE_VALUES = new ArrayList<> (Arrays.asList(
        "-12",
        "-11",
        "-10",
        "-9",
        "-8",
        "-7",
        "-6",
        "-5",
        "-4",
        "-3",
        "-2",
        "-1",
        "0", // UTC tiempo universal coordinado
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "10",
        "11",
        "12",
        // Regiones con excepciones
        "14", // LINE ISLANDS
        "13", // KIRIBATY
        "-9.5", // 9 1/2 ILES MARQUICES
        "-3.5", // 3 1/2 ISLAND OF NEWFOUNDLAND
        "3.5", // 3 1/2 IRAN
        "4.5", // 4 1/2 AFGANISTAN
        "5.5", // 5 1/2 PAKISTAN, LAKSHADWEEB (INDIA)
        "5.75", // 5 3/4 NEPAL
        "6.5", // 6 1/2 BURMA, ISLANDS (Autralia)
        "8.75", // 8 3/4 AUSTRALIA (Perth)
        "9.5", // 9 1/2 Australia (Alice Springs)
        "10.5", // 10 1/2 Lord Howe Island (AUSTL)
        "12.75" // 12 3/4 CHATLAM ISLANDS
    ));

    // RETURN_WORLD_TIME = true; ->  La aplicación asume que la hora recibida, es la hora utc en la region 0, por lo tanto lo convierte en la región recivida timezone
    // RETURN_WORLD_TIME = false; ->  La aplicación asume que la hora recibida, es la hora utc en la region con el timezone, por lo tanto lo convierte en la región utc en 0
    public static final boolean RETURN_WORLD_TIME = true;
    public static final int FLAG_VALUE =  (RETURN_WORLD_TIME)? 1: -1; // oscilación de acción

    /**
     *
     * @param time
     * @param separator
     * @return data
     */
    public static Hashtable<String, Integer> getDataTime(String time, char separator){
        Hashtable<String, Integer> data = new Hashtable<>();
        byte separatorCount = 0; // separator (:)
        String hh = "";
        String mm = "";
        String ss = "";
        try{
            // Separar horas, minutos y segundos
            for(int i = 0; i < time.length(); i++) {
                if (time.charAt(i) == separator) {
                    separatorCount++;
                }else if (separatorCount == 0)
                    hh += time.charAt(i);
                else if (separatorCount == 1)
                    mm += time.charAt(i);
                else if (separatorCount == 2)
                    ss += time.charAt(i);
            }
            data.put("hour", Integer.parseInt(hh));
            data.put("minute", Integer.parseInt(mm));
            data.put("second", Integer.parseInt(ss));
            if(data.get("hour") < 0 || data.get("hour") > 23)
                data.put("hour", -1);
            if(data.get("minute") < 0 || data.get("minute") > 59)
                data.put("minute", -1);
            if(data.get("second") < 0 || data.get("second") > 59)
                data.put("second", -1);
            return data;
        }catch (Exception e){
            System.out.println("ERROR: " + e.getMessage());
            data.put("hour", -1);
            data.put("minute", -1);
            data.put("second", -1);
            return data;
        }
    }

    /**
     * Retorna los segundos que se deven agregar o restar de la hora
     * @param timezone
     * @return seconds
     */
    public static int getSecondsIncremented(String timezone){
        // en una hora existen 3600 segundos
        int seconds = (int)(Float.parseFloat(timezone) * 3600);
        return seconds;
    }

    public static boolean isDataValid(Hashtable<String, Integer> datatime, String timezone){
        if((datatime.get("hour") != -1 &&
                datatime.get("minute") != -1 &&
                datatime.get("second") != -1) &&
                Tools.TIMEZONE_VALUES.contains(timezone)){
            return true;
        }else return false;

    }

}
