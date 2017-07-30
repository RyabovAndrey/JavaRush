package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fl=new FileInputStream(args[0]);
        Map<Integer,Integer> m=new HashMap<>();
        while (fl.available()>0) {
            int d=fl.read();
            if (!m.containsKey(d)) m.put(d,1);
            else m.replace(d,m.get(d)+1);
        }
        int[] ee=new int[m.size()];
        int l=0;
        for (Map.Entry ff:m.entrySet()) {
            ee[l]= (int) ff.getKey();
            l++;
        }
        for (int i = 0; i <ee.length ; i++) {
            for (int j = 0; j <ee.length-1 ; j++) {
                if (ee[j]>ee[j+1]) {
                        int r=ee[j+1];
                        ee[j+1]=ee[j];
                        ee[j]=r;
                }
            }
        }
        for (int i = 0; i <ee.length ; i++) {
            int x=m.get(ee[i]);
            System.out.print((char)ee[i]);
            System.out.println(" "+x);

        }
        fl.close();
    }
}
