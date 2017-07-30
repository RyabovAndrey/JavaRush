package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(Statics.FILE_NAME));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String st="";

        while (st!=null) {
            try {
                st=reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (st!=null) {
                lines.add(st);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
