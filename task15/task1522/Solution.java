package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    static {
        try {
            readKeyFromConsoleAndInitPlanet();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readKeyFromConsoleAndInitPlanet() throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String m=reader.readLine();

        if (m.equals(Planet.EARTH) || m.equals(Planet.SUN) || m.equals(Planet.MOON) ){

            if (m.equals(Planet.EARTH)) thePlanet=Earth.getInstance();

            if (m.equals(Planet.SUN)) thePlanet=Sun.getInstance();

            if (m.equals(Planet.MOON)) thePlanet=Moon.getInstance();
        }
        else thePlanet=null;

    }
}
