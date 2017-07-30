package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        String ar="", ss="";
        Sex sss;
        Person pp;
        SimpleDateFormat ff=new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        SimpleDateFormat ft=new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        switch (args[0]) {
            case "-i" :{
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        pp = allPeople.get(Integer.parseInt(args[i]));
                        if (pp.getSex() == Sex.FEMALE) ss = "ж";
                        else ss = "м";
                        System.out.println(pp.getName() + " " + ss + " " + ff.format(pp.getBirthDay()));
                    }

                }
                break;
            }
            case "-c" :{
                synchronized (allPeople) {
                    for (int i = 0; i < (args.length - 1) / 3; i++) {
                        if (args[i * 3 + 2].equals("м"))
                            pp = Person.createMale(args[i * 3 + 1], ft.parse(args[i * 3 + 3]));
                        else pp = Person.createFemale(args[i * 3 + 1], ft.parse(args[i * 3 + 3]));
                        allPeople.add(pp);
                        System.out.println(allPeople.indexOf(pp));
                    }

                }
                break;
            }
            case "-u" :{
                synchronized (allPeople) {
                    for (int i = 0; i < (args.length - 1) / 4; i++) {
                        pp = allPeople.get(Integer.parseInt(args[i * 4 + 1]));
                        pp.setName(args[i * 4 + 2]);
                        if (args[i * 4 + 3].equals("м"))
                            pp.setSex(Sex.MALE);
                        else pp.setSex(Sex.FEMALE);
                        pp.setBirthDay(ft.parse(args[i * 4 + 4]));
                    }

                }
                break;
            }
            case "-d" :{
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        pp = allPeople.get(Integer.parseInt(args[i]));
                        pp.setName(null);
                        pp.setSex(null);
                        pp.setBirthDay(null);
                    }

                }
                break;
            }
        }
    }
}
