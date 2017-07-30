package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int n1=0,n2=0;
            n1=Integer.parseInt(reader.readLine());
            if (n1<=0)
                throw new NumberFormatException();
            n2=Integer.parseInt(reader.readLine());
            if (n2<=0)
                throw new NumberFormatException();
        int m=Math.min(n1,n2);
        int d=0;
        for (int i = 1; i <m+1 ; i++) {
            if (n1%i==0 && n2%i==0) d=i;
        }
        System.out.println(d);
    }
}
