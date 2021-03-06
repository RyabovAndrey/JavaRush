package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String m="";
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String a=reader.readLine();
        reader.close();
        BufferedReader f=new BufferedReader(new FileReader(a));

        while (f.ready()) {
            m=m+f.readLine();
        }
        f.close();
 //      m="Киев Нью-Йорк Амстердам Вена Мельбурн Вена Архангельск Саратов Вена";
        StringBuilder result = getLine(m.split(" "));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {

        StringBuilder result = new StringBuilder();

        if (words == null || words.length == 0) return result;

        if (words.length==1 || words[0].equals("")) return result.append(words[0]);



        ArrayList<String> wordsList = new ArrayList<>();



        wordsList.addAll(Arrays.asList(words));

        while (wordsList.remove("")){

            wordsList.remove("");

        }

        while (isYes(wordsList)) {

            Collections.shuffle(wordsList);

        }

        for (String word: wordsList){

            result.append(word).append(" ");

        }

        result.deleteCharAt(result.length()-1);

        return result;

    }



    public static boolean isYes(ArrayList<String> wordsList) {

        for (int i = 0; i < wordsList.size() - 1; i++) {

            String firstWord = wordsList.get(i).toLowerCase();

            String secondWord = wordsList.get(i + 1).toLowerCase();

            if (firstWord.charAt(firstWord.length() - 1) != secondWord.charAt(0)) return true;

        }

        return false;

    }
}
