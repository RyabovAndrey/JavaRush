package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

/* 
Самые частые байты
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
        int k=Integer.MIN_VALUE;
        for (HashMap.Entry n:s.entrySet()) {
            k=Math.max(k, (int) n.getValue());
        }

        for (HashMap.Entry n:s.entrySet()) {
            if ((int) n.getValue()==k)
                System.out.print(n.getKey()+" ");
        }
        ff.close();
    }
}
