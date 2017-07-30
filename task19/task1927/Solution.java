package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream s=System.out;
        ByteArrayOutputStream h=new ByteArrayOutputStream();
        PrintStream l=new PrintStream(h);
        System.setOut(l);
        testString.printSomething();
        String r=h.toString();
        System.setOut(s);
        int j=0;
        for (String m: r.replaceAll("\n"," ").split(" ")) {
            if (j<2) {
                System.out.println(m);
                j++;
            }
            else {
                j=1;
                System.out.println("JavaRush - курсы Java онлайн");
                System.out.println(m);
            }

        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
