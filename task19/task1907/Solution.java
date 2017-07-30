package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String a=reader.readLine();
        reader.close();
        FileReader f=new FileReader(a);
        String s="";
        int m=0;
        while (f.ready()) {
            s+=(char)f.read();
        }
        s = s.replaceAll("[\\p{Punct}+|\\s]"," ");
        String[] lineArr = s.split(" ");
        for (int i = 0; i < lineArr.length; i++) {
            if (lineArr[i].equals("world")){
                m = m + 1;
            }
        }
        f.close();
        System.out.println(m);
    }
}
