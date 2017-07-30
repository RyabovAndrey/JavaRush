package com.javarush.task.task18.task1801;

import java.io.*;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String ff=reader.readLine();
        FileInputStream fl=new FileInputStream(ff);
        int s=Integer.MIN_VALUE;
        while (fl.available()>0) {
            int d=fl.read();
            s=Math.max(s,d);
        }
        System.out.println(s);
        fl.close();
    }
}
