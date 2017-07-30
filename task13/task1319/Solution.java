package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.Iterator;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String fl=reader.readLine();
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(fl));
        String s=reader.readLine();
        while (!s.equals("exit")) {
            bufferedWriter.append(s);
            bufferedWriter.newLine();
            s = reader.readLine();
            System.out.println(s);
        }
        bufferedWriter.append("exit");
        bufferedWriter.flush();
        bufferedWriter.close();
        reader.close();
    }
}
