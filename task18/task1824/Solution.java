package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String m="";
        ArrayList<FileInputStream> fi=new ArrayList<>();
        while (true) {
          m=reader.readLine();
            try {
                FileInputStream fl=new FileInputStream(m);
                fi.add(fl);
            } catch (FileNotFoundException e) {
                System.out.println(m);
                for (FileInputStream f:fi) {
                    f.close();
                }
                break;
            }

        }

    }
}
