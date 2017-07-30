package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String m;
        int part=0;
        String path="";
        String p="";
        String pa="";
        int j=0;
        Map<Integer,String> u=new HashMap<>();
        while (!"end".equals(m=reader.readLine())) {
            while(true) {
                p=m.substring(m.length()-j-1,m.length()-j);
                if (p.equals("t")) {
                    part=Integer.parseInt(pa);
                break;
                }
                else {
                    pa=p+pa;
                    j++;
                }
            }
            u.put(part,m);
            j=0;
            pa="";
            while(true) {
                p=m.substring(m.length()-j-1,m.length()-j);
                if (p.equals(".")) {
                    break;
                }
                else {

                    j++;
                }
            }
            path=m.substring(0,m.length()-j-1);
            j=0;
        }
        int[] h=new int[u.size()];
        j=0;
        for (Map.Entry l:u.entrySet()) {
            h[j]=Integer.parseInt(l.getKey().toString());
            j++;
        }
        for (int i = 0; i <h.length ; i++) {
            for (int k = 0; k <h.length-1 ; k++) {
                if (h[k]>h[k+1]) {
                    int y=h[k+1];
                    h[k+1]=h[k];
                    h[k]=y;
                }
            }
        }

        FileOutputStream fo=new FileOutputStream(path,false);
        for (int i = 0; i <h.length ; i++) {
            FileInputStream fi=new FileInputStream(u.get(h[i]));
            byte[] by=new byte[fi.available()];
            int co=fi.read(by);
            fo.write(by,0,co);
            fi.close();
        }
        fo.close();
    }
}
