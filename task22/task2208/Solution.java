package com.javarush.task.task22.task2208;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map <String , String> m=new HashMap<>();
        m.put("age", null);
        m.put("city", "Kiev");
        m.put("country", "Ukraine");
        m.put("name", "Ivanov");
        String l=getQuery(m);
        System.out.println(l);
    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder result=new StringBuilder();
        if (params == null || params.isEmpty()) return result.toString();
        for (Map.Entry<String, String> entry : params.entrySet()) {

            if (entry.getValue() == null || entry.getKey() == null) continue;

            result.append(entry.getKey()).append(" = '").append(entry.getValue()).append("' and ");

        }

        if (result.length() > 5) result.delete(result.length() - 5, result.length());

        return result.toString();
    }
}
