package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String fl=reader.readLine();
        FileInputStream ff=new FileInputStream(fl);
        HashMap<Integer,Integer> s=new HashMap<>();
        while (ff.available()>0) {
            int d=ff.read();
            if ( !s.containsKey(d)) s.put(d,1);
            else s.replace(d,s.get(d)+1);
        }
        int k=Integer.MAX_VALUE;
        for (HashMap.Entry n:s.entrySet()) {
            k=Math.min(k, (int) n.getValue());
        }

        for (HashMap.Entry n:s.entrySet()) {
            if ((int) n.getValue()==k)
                System.out.print(n.getKey()+" ");
        }
        ff.close();
    }
}
