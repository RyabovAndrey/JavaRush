package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String a1=reader.readLine();
        String a2=reader.readLine();
        String a3=reader.readLine();
        reader.close();
        FileOutputStream f1 = new FileOutputStream(a1);
        FileInputStream f2=new FileInputStream(a2);
        FileInputStream f3=new FileInputStream(a3);

        while (f2.available()>0) {
            f1.write(f2.read());
        }
        while (f3.available()>0) {
            f1.write(f3.read());
        }
        f1.close();
        f2.close();
        f3.close();
    }
}
