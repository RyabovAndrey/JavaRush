package com.javarush.task.task32.task3202;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter w = new StringWriter();
        try {
            while (is.available() > 0) {
                byte[] b = new byte[1024];
                int count = is.read(b);
                String s = new String(b, 0, count);
                w.append(s);
            }
        } catch (Exception e) {
            return new StringWriter();
        }
        return w;
    }
}