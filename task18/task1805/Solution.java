package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String fl=reader.readLine();
        FileInputStream ff=new FileInputStream(fl);
        ArrayList<Integer> aa=new ArrayList<>();
        while (ff.available()>0) {
            int d=ff.read();
            if ( !aa.contains(d)) aa.add(d);
        }
        int[] j=new int[aa.size()];
        int i=0;
        for (int e:aa) {
            j[i]=e;
            i++;
        }
        for (int k = 0; k < j.length; k++) {
            for (int l = 0; l <j.length-1; l++) {
                if (j[l]>j[l+1]) {
                    int t=j[l+1];
                    j[l+1]=j[l];
                    j[l]=t;
                }
            }
        }
        for (int k = 0; k <j.length ; k++) {
            System.out.print(j[k]+" ");
        }
ff.close();
    }
}
