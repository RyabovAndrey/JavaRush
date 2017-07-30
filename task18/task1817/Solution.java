package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fl=new FileInputStream(args[0]);
        int m=0,n=0;
        double s=0;
        while (fl.available()>0) {
            int d=fl.read();
            m++;
            if (d==" ".codePointAt(0)) n++;
        }
        fl.close();
        s=(double)n/(double)m*100;
        System.out.format("%.2f%n",s);
    }
}
