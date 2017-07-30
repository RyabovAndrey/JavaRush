package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> pl=new ArrayList<>();
        ArrayList<String> zl=new ArrayList<>();
        int st=0,sz=0,ll=0;
        String w="";
        boolean pr=false, ra=false;
        String s=reader.readLine();
        for (int i = 0; i <s.length(); i++) {
            if (pr==false) {
                if (s.substring(i,i+1).equals("?")) {
                    pr = true;
                    st=i+1;
                }
            }
            else {
                if (i<s.length()-1) {
                    if (ra==false) {
                        if (s.substring(i, i + 1).equals("&")) {
                            w=s.substring(st, i);
                            pl.add(w);
                            st = i + 1;
                        }
                        if (s.substring(i, i + 1).equals("=")) {
                            w=s.substring(st, i);
                            pl.add(w);
                            st = i + 1;
                            sz=st;
                            ra=true;
                        }
                    }
                    else {
                        if (s.substring(i, i + 1).equals("&")) {
                            ra = false;
                            if (w.equals("obj"))
                            zl.add(s.substring(sz, i));
                            st=i+1;
                            sz=i+1;
                        }
                    }
                }
                else {
                    if (ra==false)
                    pl.add(s.substring(st, i+1));
                    else {
                        if (w.equals("obj"))
                            zl.add(s.substring(sz, i+1));
                    }
                }
            }

        }
        for (String m: pl) {
            if (ll==pl.size()-1) System.out.print(m);
            else {
                System.out.print(m+" ");
                ll++;
            }

        }
        System.out.println();
        if (!zl.isEmpty()) {
            for (String u:zl) {
                try {
                    double ddd=Double.parseDouble(u);
                    alert(ddd);
                } catch (NumberFormatException e) {
                    alert(u);
                }
            }
        }

    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
