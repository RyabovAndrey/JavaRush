package com.javarush.task.task39.task3909;

/* 
Одно изменение
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isOneEditAway("", "")); // true

        System.out.println(isOneEditAway("", "m")); //true

        System.out.println(isOneEditAway("m", "")); //true

        //System.out.println(isOneEditAway("m", null)); //

        System.out.println("------");

        System.out.println(isOneEditAway("mama", "ramas")); //false

        System.out.println(isOneEditAway("mamas", "rama")); //false

        System.out.println(isOneEditAway("rama", "mama")); //true

        System.out.println(isOneEditAway("mama", "dama")); //true

        System.out.println(isOneEditAway("ama", "mama"));  //true

        System.out.println(isOneEditAway("mama", "ama")); //true


    }

    public static boolean isOneEditAway(String first, String second) {

        if (first.equals("") && second.equals(""))
            return true;


        if (first == null || second == null)
            return false;

        if (Math.abs(first.length() - second.length()) > 1)
            return false;

        if (first.equals(second))
            return true;

        String shorterString;
        String longerString;



        if (first.length() <= second.length()) {
            shorterString = first;
            longerString = second;

        } else {
            shorterString = second;
            longerString = first;

        }

        if (shorterString.equals(longerString))
            return true;

        if (shorterString.length() == 0)
            return true;



        for (int i = 0; i < shorterString.length(); i++) {

            if (i == shorterString.length() - 1) {
                if (shorterString.length() != longerString.length()) {
                    return shorterString.charAt(i) == longerString.charAt(i + 1);
                }
                return true;
            }

            if (shorterString.charAt(i) != longerString.charAt(i)) {

                if (shorterString.substring(i + 1, shorterString.length()).equals(longerString.substring(i + 1, longerString.length())))
                    return true;

                return shorterString.substring(i, shorterString.length()).equals(longerString.substring(i + 1, longerString.length()));

            }
        }

        return false;
    }
}
