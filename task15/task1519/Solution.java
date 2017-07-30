package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        boolean s=true;
        String m="";
        double d=0;
        int f=0;
        short h;
        while (s==true)  {
            m=reader.readLine();
            if (m.equals("exit")) s=false;
            else {
                if (m.contains(".")) {
                    try {
                        d = Double.parseDouble(m);
                        print(d);
                    } catch (NumberFormatException e) {
                        print(m);
                    }
                } else {
                    try {
                        f = Integer.parseInt(m);
                        if (f > 0 && f < 128) {
                            try {
                                h = Short.parseShort(m);
                                print(h);
                            } catch (NumberFormatException e) {
                                print(f);
                            }
                        } else print(f);
                    } catch (NumberFormatException e) {
                        print(m);
                    }


                }

            }


        }

    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
