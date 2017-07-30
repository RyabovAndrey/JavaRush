package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    static String stringForm = "%-8.8s%-30.30s%-8.8s%-4.4s";
    public static void main(String[] args) throws Exception {
        if (args.length>0) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String a = reader.readLine();
            BufferedReader fl = new BufferedReader(new FileReader(a));
            String m;
            ArrayList<String> b=new ArrayList<>();
            while (null != (m = fl.readLine())) {
                if (m != null) {
                    b.add(m);
                }
            }
            fl.close();
            FileWriter fw = new FileWriter(a);
            if (args[0].equals("-u")) {
                for (String q:b) {
                    if (Integer.parseInt(q.substring(0, 8).trim())==Integer.parseInt(args[1]))
                        fw.write(String.format(stringForm, args[1], args[2], args[3], args[4])+"\r\n");
                    else
                        fw.write(q+"\r\n");
                }
            }
            if (args[0].equals("-d")) {
                for (String q:b) {
                    if (Integer.parseInt(q.substring(0, 8).trim())!=Integer.parseInt(args[1]))
                        fw.write(q+"\r\n");
                }
            }
            fw.close();

        }
    }
}
