package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String a1=reader.readLine();
        String a2=reader.readLine();
        FileInputStream f1=new FileInputStream(a1);
        FileOutputStream f2=new FileOutputStream(a2);
        byte[] g=new byte[f1.available()];
        f1.read(g);
        for (int i = g.length-1; i >=0 ; i--) {
            f2.write(g[i]);
        }
        f1.close();
        f2.close();
    }
}
