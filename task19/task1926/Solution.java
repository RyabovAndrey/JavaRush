package com.javarush.task.task19.task1926;

/* 
Перевертыши
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
        BufferedReader f=new BufferedReader(new FileReader(a));
        String k;
        while (null!=(k=f.readLine())) {
            System.out.println(new StringBuffer(k).reverse());
        }
        f.close();
    }
}
