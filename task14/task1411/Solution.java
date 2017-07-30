package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Looser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;
        key=reader.readLine();
        while (key.equals("coder") || key.equals("user") || key.equals("loser") || key.equals("proger"))
        {
            if (key.equals("coder")) doWork(new Person.Coder());
            if (key.equals("user")) doWork(new Person.User());
            if (key.equals("loser")) doWork(new Person.Loser());
            if (key.equals("proger")) doWork(new Person.Proger());
            key=reader.readLine();
        }
    }

    public static void doWork(Person person) {
        if (person instanceof Person.User) ((Person.User) person).live();
        if (person instanceof Person.Proger) ((Person.Proger) person).enjoy();
        if (person instanceof Person.Coder) ((Person.Coder) person).coding();
        if (person instanceof Person.Loser) ((Person.Loser) person).doNothing();
    }
}
