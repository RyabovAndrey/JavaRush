package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream f=System.out;
        ByteArrayOutputStream g=new ByteArrayOutputStream();
        PrintStream l=new PrintStream(g);
        System.setOut(l);
        testString.printSomething();
        String r=g.toString();
        System.setOut(f);
        String equation = r.replaceAll("[\\n|\\r]", "");
        String[] chunks = equation.split(" ");
        int result = 0;
        switch (chunks[1]) {
            case "+":
                result = Integer.parseInt(chunks[0]) + Integer.parseInt(chunks[2]);
                break;
            case "-":
                result = Integer.parseInt(chunks[0]) - Integer.parseInt(chunks[2]);
                break;
            case "*":
                result = Integer.parseInt(chunks[0]) * Integer.parseInt(chunks[2]);
                break;
        }
        System.out.println(equation + result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

