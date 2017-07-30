package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String fl1=reader.readLine();
        String fl2=reader.readLine();
        BufferedReader f1=new BufferedReader(new FileReader(fl1));
        BufferedReader f2=new BufferedReader(new FileReader(fl2));
        String st="";
        while (true) {
            st=f1.readLine();
            if (st== null) break;
            else
                allLines.add(st);
        }
        st="";
        while (true) {
            st=f2.readLine();
            if (st== null) break;
            else
                forRemoveLines.add(st);
        }
        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
        f1.close();
        f2.close();
    }

    public void joinData () throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        }
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
