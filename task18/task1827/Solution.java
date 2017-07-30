package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;


public class Solution {
    static String stringForm = "%-8.8s%-30.30s%-8.8s%-4.4s";
    public static void main(String[] args) throws Exception {
        if (args.length>0) {
            if (args[0].equals("-c")) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String a = reader.readLine();
                BufferedReader fl = new BufferedReader(new FileReader(a));
                String m;
                ArrayList<Integer> h = new ArrayList<>();
                ArrayList<String> b=new ArrayList<>();
                while (null != (m = fl.readLine())) {
                    if (m != null) {
                        h.add(Integer.parseInt(m.substring(0, 8).trim()));
                        b.add(m);
                    }
                }
                fl.close();
                int j = Integer.MIN_VALUE;
                for (int f : h) {
                    j = Math.max(j, f);
                }
                j++;
                FileWriter fw = new FileWriter(a);
                for (String q:b) {
                    fw.write(q+"\r\n");
                }
                fw.write(String.format(stringForm, j, args[1], args[2], args[3]));
                fw.close();
            }
        }
    }
}
