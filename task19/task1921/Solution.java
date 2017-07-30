package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader f=new BufferedReader(new FileReader(args[0]));
        while (f.ready()) {
            String ss=f.readLine();
            String[] s=ss.split(" ");
            String name=ss.replaceAll("[\\w]", "").trim();
            Date bd=new GregorianCalendar(Integer.parseInt(s[s.length-1]), Integer.parseInt(s[s.length-2])-1, Integer.parseInt(s[s.length-3])).getTime();
            PEOPLE.add(new Person(name,bd));
        }
        f.close();
//        for (Person t:PEOPLE) {
//            System.out.println(t.getName());
//            System.out.println(t.getBirthday());
//        }
    }
}
