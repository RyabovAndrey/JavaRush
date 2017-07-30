package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader f1 = new FileReader(reader.readLine());
        FileReader f2 = new FileReader(reader.readLine());
        reader.close();
        List<String> original = new BufferedReader(f1).lines().collect(Collectors.toList());
        List<String> modified = new BufferedReader(f2).lines().collect(Collectors.toList());
        f1.close();
        f2.close();
        while (original.size() != 0 & modified.size() != 0) {
            if (original.get(0).equals(modified.get(0))) {
                lines.add(new LineItem(Type.SAME, original.remove(0)));
                modified.remove(0);
            } else if (modified.size() != 1 && original.get(0).equals(modified.get(1))) {
                lines.add(new LineItem(Type.ADDED, modified.remove(0)));
            } else if (original.size() != 1 && original.get(1).equals(modified.get(0))) {
                lines.add(new LineItem(Type.REMOVED, original.remove(0)));
            }
        }
        if (original.size() != 0) {
            lines.add(new LineItem(Type.REMOVED, original.remove(0)));
        } else if (modified.size() != 0) {
            lines.add(new LineItem(Type.ADDED, modified.remove(0)));
        }
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
