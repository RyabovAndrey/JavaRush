package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String fl=reader.readLine();
        FileInputStream ff=new FileInputStream(fl);
        int m=0;
        while (ff.available()>0) {
            int d=ff.read();
            if (d==(int)',') m++;
        }
        System.out.println(m);
        ff.close();
    }
}
