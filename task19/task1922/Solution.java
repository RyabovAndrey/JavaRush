package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String a=reader.readLine();
        reader.close();
        BufferedReader f=new BufferedReader(new FileReader(a));
        while (f.ready()) {
            int r=0;
            String mm=f.readLine();
            String[] h=mm.split(" ");
            for (String j:h) {
                for (String d:words) {
                    if (j.equals(d)) r++;
                }
            }
            if (r==2) System.out.println(mm);
        }
        f.close();
    }
}
