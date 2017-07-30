package com.javarush.task.task19.task1913;

/* 
Выводим только цифры
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream g=System.out;
        ByteArrayOutputStream h=new ByteArrayOutputStream();
        PrintStream l=new PrintStream(h);
        System.setOut(l);
        testString.printSomething();
        String v=h.toString();
        System.setOut(g);
        System.out.println(v.replaceAll("[^\\p{Digit}]", ""));
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
