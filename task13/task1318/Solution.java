package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        String p=r.readLine();
        FileInputStream in=new FileInputStream(p);
        while (in.available()>0) {
            int d=in.read();
            System.out.print((char)d);
        }
        System.out.println();
        in.close();
        r.close();

    }
}