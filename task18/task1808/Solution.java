package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String a1=reader.readLine();
        String a2=reader.readLine();
        String a3=reader.readLine();
        FileInputStream f1=new FileInputStream(a1);
        FileOutputStream f2=new FileOutputStream(a2);
        FileOutputStream f3=new FileOutputStream(a3);
        int m=0;
        if (f1.available()%2==0) m=f1.available()/2;
        else m=(f1.available()-1)/2+1;
        byte[] b1=new byte[m];
        byte[] b2=new byte[f1.available()-m];
        int c1=f1.read(b1);
        int c2=f1.read(b2);
        f2.write(b1,0,c1);
        f3.write(b2,0,c2);
        f1.close();
        f2.close();
        f3.close();
    }
}
