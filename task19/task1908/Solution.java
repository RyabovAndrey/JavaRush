package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static boolean isNumeric(String s) {
        return s.matches("[-+]?\\d*\\.?\\d+");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String a1=reader.readLine();
        String a2=reader.readLine();
        reader.close();
        BufferedReader f1=new BufferedReader(new FileReader(a1));
        BufferedWriter f2=new BufferedWriter(new FileWriter(a2));
        String s;
        while (null!=(s=f1.readLine())) {
            for (String ss:s.split(" ")) {
                if (isNumeric(ss))
                    f2.write(Integer.parseInt(ss)+" ");
            }
        }
        f1.close();
        f2.close();
    }
}
