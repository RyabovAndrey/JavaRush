package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        //Программа запускается с одним параметром: id (int).


        //Считать с консоли имя файла.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        reader.close();

        //Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
        BufferedReader br = new BufferedReader(new FileReader(path));

        int id = Integer.parseInt(args[0]);
        while (true) {
            String s = br.readLine();
            if (s == null) {
                break;
            }

            if (id == Integer.parseInt(s.split(" ")[0])) {
                System.out.println(s);
                br.close();
                break;
            }
        }
    }
}
