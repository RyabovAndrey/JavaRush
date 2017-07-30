package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String fl=reader.readLine();
        FileInputStream ff=new FileInputStream(fl);
        int s=Integer.MAX_VALUE;
        while (ff.available()>0) {
            int d=ff.read();
            s=Math.min(s,d);
        }
        System.out.println(s);
        ff.close();
    }
}
