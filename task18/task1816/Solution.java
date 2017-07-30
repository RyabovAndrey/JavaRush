package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fl=new FileInputStream(args[0]);
        String[] a=new String[26];
        a[0]="a";
        a[1]="b";
        a[2]="c";
        a[3]="d";
        a[4]="e";
        a[5]="f";
        a[6]="g";
        a[7]="h";
        a[8]="j";
        a[9]="k";
        a[10]="l";
        a[11]="m";
        a[12]="n";
        a[13]="o";
        a[14]="p";
        a[15]="q";
        a[16]="r";
        a[17]="s";
        a[18]="t";
        a[19]="u";
        a[20]="v";
        a[21]="w";
        a[22]="x";
        a[23]="y";
        a[24]="z";
        a[25]="i";
        int m=0;
        while ((fl.available()>0)) {
            int d=fl.read();
            for (int i = 0; i <a.length ; i++) {
                if (a[i].codePointAt(0)==d || a[i].toUpperCase().codePointAt(0)==d) {
                    m++;
                }
            }
        }
        fl.close();
        System.out.println(m);

    }
}
