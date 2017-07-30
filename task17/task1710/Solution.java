package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

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
        if (args[0].equals("-i")) {
            pp=allPeople.get(Integer.parseInt(args[1]));
            if (pp.getSex()==Sex.FEMALE) ss="ж";
            else ss="м";
            System.out.println(pp.getName()+" "+ss+" "+ff.format(pp.getBirthDay()));
        }
        if (args[0].equals("-c")) {
            if (args[2].equals("м"))
                pp=Person.createMale(args[1],ft.parse(args[3]));
             else pp=Person.createFemale(args[1],ft.parse(args[3]));
             allPeople.add(pp);
            System.out.println(allPeople.indexOf(pp));
        }
        if (args[0].equals("-u")) {
            pp=allPeople.get(Integer.parseInt(args[1]));
            pp.setName(args[2]);
            if (args[3].equals("м"))
                pp.setSex(Sex.MALE);
            else pp.setSex(Sex.FEMALE);
            pp.setBirthDay(ft.parse(args[4]));
        }
        if (args[0].equals("-d")) {
            pp=allPeople.get(Integer.parseInt(args[1]));
            pp.setName(null);
            pp.setSex(null);
            pp.setBirthDay(null);
        }
    }
}
