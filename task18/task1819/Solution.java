package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String a1=reader.readLine();
        String a2=reader.readLine();

        FileInputStream f1=new FileInputStream(a1);
        byte[] b1=new byte[f1.available()];
        int c1=f1.read(b1);
        FileInputStream f2=new FileInputStream(a2);
        byte[] b2=new byte[f2.available()];
        int c2=f2.read(b2);
        f1.close();
        FileOutputStream f3=new FileOutputStream(a1,false);
        f3.write(b2,0,c2);
        f3.write(b1,0,c1);
        f2.close();
        f3.close();
    }
}
