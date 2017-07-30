package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String a1=reader.readLine();
        String a2=reader.readLine();
        reader.close();
        FileReader f1=new FileReader(a1);
        FileWriter f2=new FileWriter(a2);
        int i=1;
        while (f1.ready()) {
            int g=f1.read();
            if (i%2==0) f2.write(g);
            i++;
        }
        f1.close();
        f2.close();

    }
}
