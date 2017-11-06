package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        String  m="";
        RandomAccessFile r=new RandomAccessFile(args[0],"rw");
        byte[] b=new byte[args[2].length()];
        r.seek(Long.parseLong(args[1]));
        r.read(b,0,args[2].length());
        String s=convertByteToString(b);
        if (s.equals(args[2])) m="true";
        else m="false";
        r.seek(r.length());
        r.write(m.getBytes());
        r.close();
    }
    public static String convertByteToString(byte readBytes[]) {
        return new String(readBytes);
    }
}
