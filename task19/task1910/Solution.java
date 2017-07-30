package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String a1=reader.readLine();
        String a2=reader.readLine();
        reader.close();
        BufferedReader f1=new BufferedReader(new FileReader(a1));
        BufferedWriter f2=new BufferedWriter(new FileWriter(a2));
        while (f1.ready()) {
            f2.write(f1.readLine().replaceAll("[\\p{Punct}|\\n]",""));
        }
        f1.close();
        f2.close();
    }
}
