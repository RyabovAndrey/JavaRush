package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(new FileInputStream(reader.readLine()));
        ArrayList<Integer> ar=new ArrayList<>();
        while (scanner.hasNextInt()) {
            int l=scanner.nextInt();
            if (l%2==0) ar.add(l);
        }
        scanner.close();
        reader.close();
        Integer[] v={};
        v=ar.toArray(v);
        for (int i = 0; i <v.length; i++) {
            for (int j = 0; j <v.length-1 ; j++) {
                if (v[j]>v[j+1]) {
                        int m=v[j];
                        v[j]=v[j+1];
                        v[j+1]=m;
                }
            }
        }
        for (int i = 0; i <v.length ; i++) {
            System.out.println(v[i]);

        }
    }
}
