package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String f1 = br.readLine();

        String f2 = br.readLine();

        br.close();



        ArrayList<String> list = new ArrayList<>();

        FileInputStream fis = new FileInputStream(f1);

        byte[] b = new byte[fis.available()];



        while (fis.available() > 0)

        {

            fis.read(b);

        }



        String temp = new String(b);

        for (String z : temp.split(" "))

        {

            float x = Float.parseFloat(z);

            list.add(Math.round(x) + " ");

        }



        FileOutputStream fos = new FileOutputStream(f2);

        for (String h : list)

        {

            fos.write(h.getBytes());

        }

        fis.close();

        fos.close();

    }
}
