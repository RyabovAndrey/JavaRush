package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0,"ноль");
        map.put(1,"один");
        map.put(2,"два");
        map.put(3,"три");
        map.put(4,"четыре");
        map.put(5,"пять");
        map.put(6,"шесть");
        map.put(7,"семь");
        map.put(8,"восемь");
        map.put(9,"девять");
        map.put(10,"десять");
        map.put(11,"одиннадцать");
        map.put(12,"двенадцать");
    }



    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String a=reader.readLine();
        reader.close();
        BufferedReader f=new BufferedReader(new FileReader(a));
        String u;
        while (f.ready()) {
            u=f.readLine();
            for (Map.Entry<Integer,String> z:map.entrySet())
                u=u.replaceAll("\\b"+z.getKey().intValue()+"\\b",z.getValue());
            System.out.println(u);

        }
        f.close();
    }
}
