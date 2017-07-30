package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r=new BufferedReader(new FileReader(args[0]));
        BufferedWriter w=new BufferedWriter(new FileWriter(args[1]));
        String u="";
        while (r.ready()) {
            String[] s=r.readLine().split(" ");
            for (String j:s) {
                if (j.length()>6) u=u+j+",";
            }
        }
        if (u.substring(u.length()-1,u.length()).equals(","))
            u=u.substring(0,u.length()-1);
        w.write(u);
        r.close();
        w.close();
    }
}
