package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fi=new FileInputStream(args[1]);
        FileOutputStream fo=new FileOutputStream(args[2]);
        while (fi.available()>0) {
            int d=fi.read();
            if (args[0].equals("-e")) {
                fo.write(d-1);
            }
            if (args[0].equals("-d")) {
                fo.write(d+1);
            }
        }
        fi.close();
        fo.close();
    }

}
