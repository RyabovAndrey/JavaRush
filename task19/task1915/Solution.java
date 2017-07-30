package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String a=reader.readLine();
        reader.close();
        FileOutputStream f=new FileOutputStream(a);
        PrintStream s=System.out;
        ByteArrayOutputStream h=new ByteArrayOutputStream();
        PrintStream l=new PrintStream(h);
        System.setOut(l);
        testString.printSomething();
        String r=h.toString();
        System.setOut(s);
        System.out.println(r);
        f.write(r.getBytes());
        f.close();

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

