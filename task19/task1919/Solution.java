package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader f=new BufferedReader(new FileReader(args[0]));
        Map<String,Double> m=new HashMap<>();
        TreeSet<String> ts=new TreeSet<>();
        while (f.ready()) {
            String[] g=f.readLine().split(" ");
            if (m.containsKey(g[0])) m.replace(g[0],m.get(g[0])+Double.parseDouble(g[1]));
            else {
                m.put(g[0], Double.parseDouble(g[1]));
                ts.add(g[0]);
            }
        }
        f.close();
        for (String e:ts) {
            System.out.println(e+" "+m.get(e));
        }
    }
}
