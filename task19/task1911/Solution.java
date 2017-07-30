package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream m=System.out;
        ByteArrayOutputStream os=new ByteArrayOutputStream();
        PrintStream s=new PrintStream(os);
        System.setOut(s);
        testString.printSomething();
        String r=os.toString();
        System.setOut(m);
        System.out.println(r.toUpperCase());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
