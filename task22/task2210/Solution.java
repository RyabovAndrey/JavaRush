package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String [] getTokens(String query, String delimiter) {
        ArrayList<String> a=new ArrayList();
        StringTokenizer st=new StringTokenizer(query,delimiter);
        while (st.hasMoreTokens()) {
            a.add(st.nextToken());
        }
        String[] gg=new String[a.size()];
        a.toArray(gg);
        return gg;
    }
}
