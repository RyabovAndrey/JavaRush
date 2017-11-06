package com.javarush.task.task26.task2613;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CurrencyManipulatorFactory {
    private static Map<String, CurrencyManipulator> map = new HashMap<>();

    private CurrencyManipulatorFactory() {}

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        Iterator<Map.Entry<String, CurrencyManipulator>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, CurrencyManipulator> pair = iterator.next();
            String key = pair.getKey();
            if (key.equalsIgnoreCase(currencyCode)) return pair.getValue();
        }
        map.put(currencyCode, new CurrencyManipulator(currencyCode));
        return map.get(currencyCode);
    }
}
