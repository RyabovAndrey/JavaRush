package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {
        long position=0;
        RandomAccessFile r=new RandomAccessFile(args[0],"rw");
        if (r.length()<Long.parseLong(args[1]))
            position=r.length();
        else
            position=Long.parseLong(args[1]);
        r.seek(position);
        r.write(args[2].getBytes());
        r.close();
    }
}
