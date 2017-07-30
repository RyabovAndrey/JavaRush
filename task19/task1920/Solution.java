package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader f=new BufferedReader(new FileReader(args[0]));
        Map<String,Double> g=new HashMap<>();
        while (f.ready()) {
            String[] m=f.readLine().split(" ");
            if (g.containsKey(m[0]))
                g.replace(m[0],g.get(m[0])+Double.parseDouble(m[1]));
            else
                g.put(m[0],Double.parseDouble(m[1]));
        }
        f.close();
        double y=Double.MIN_VALUE;
        for (Map.Entry<String,Double> t: g.entrySet()) {
                y=Math.max(y,t.getValue());
        }
        for (Map.Entry<String,Double> t: g.entrySet()) {
            if (y==t.getValue()) System.out.println(t.getKey());
        }
    }
}
