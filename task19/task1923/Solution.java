package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r=new BufferedReader(new FileReader(args[0]));
        BufferedWriter w=new BufferedWriter(new FileWriter(args[1]));
        while(r.ready()) {
            String[] m=r.readLine().split(" ");
            for (String word :m)
                if (!word.matches("^\\D*$"))
                    w.write(word + " ");
        }
        r.close();
        w.close();
    }
}
