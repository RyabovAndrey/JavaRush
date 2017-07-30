package com.javarush.task.task14.task1419;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        try{
            int a[]=new int[10];
            a[11] = 9; }
        catch(ArrayIndexOutOfBoundsException e){
             exceptions.add(e);
        }

 try{
 int num=Integer.parseInt ("XYZ") ;
 }catch(NumberFormatException e){
 exceptions.add(e);
 }

 try{
 String str="easysteps2buildwebsite";
 char c = str.charAt(0);
c = str.charAt(40);
 }catch(StringIndexOutOfBoundsException e){
 exceptions.add(e);
 }

try{
String str=null;
 System.out.println (str.length());
 }catch(NullPointerException e){
 exceptions.add(e);
 }

try {
 int i = -1;
int[] array = new int[i];
 }
 catch (NegativeArraySizeException e) {
 exceptions.add(e);
}

try {
 Object i = Integer.valueOf(42);
 String s = (String)i;
 }
 catch (ClassCastException e) {
exceptions.add(e);
}

try
{
Object x[]=new String[3];
 x[0]=new Integer(10);
} catch (ArrayStoreException e) {
exceptions.add(e);
 }

try
 {
Thread d1 = new Thread();
d1.start();
 d1.start();
}
catch (IllegalThreadStateException e) {
 exceptions.add(e);
}
try
{
throw new SecurityException ();
 }
 catch (SecurityException e) {
 exceptions.add(e);
 }

    }
}
