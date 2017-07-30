package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream m=System.out;
        ByteArrayOutputStream n=new ByteArrayOutputStream();
        PrintStream l=new PrintStream(n);
        System.setOut(l);
        testString.printSomething();
        String h=n.toString();
        System.setOut(m);
        System.out.println(h.replaceAll("te","??"));
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
