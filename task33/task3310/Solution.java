package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        StorageStrategy strategy = new HashMapStorageStrategy();
        testStrategy(strategy, 10000);
        OurHashMapStorageStrategy strategy2 = new OurHashMapStorageStrategy();
        testStrategy(strategy2, 10000);
        FileStorageStrategy strategy3 = new FileStorageStrategy();
        testStrategy(strategy3, 500);
        OurHashBiMapStorageStrategy strategy4 = new OurHashBiMapStorageStrategy();
        testStrategy(strategy4, 10000);
        HashBiMapStorageStrategy strategy5 = new HashBiMapStorageStrategy();
        testStrategy(strategy5, 10000);
        DualHashBidiMapStorageStrategy strategy6 = new DualHashBidiMapStorageStrategy();
        testStrategy(strategy6, 10000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> result = new HashSet<>();
        for (String s : strings)
            result.add(shortener.getId(s));
        return result;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> result = new HashSet<>();
        for (Long id : keys)
            result.add(shortener.getString(id));
        return result;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        System.out.println(strategy.getClass().getSimpleName());
        Set<String> strings = new HashSet<>();
        Long[] elements = new Long[(int) elementsNumber];
        for (int i = 0; i < elementsNumber; i++)
            strings.add(Helper.generateRandomString());
        Shortener shortener = new Shortener(strategy);
        Date startDateTime = new Date();
        Set<Long> ids = getIds(shortener, strings);
        Date finishDateTime = new Date();
        long deltaTime = finishDateTime.getTime() - startDateTime.getTime();
        Helper.printMessage(Long.toString(deltaTime));
        startDateTime = new Date();
        Set<String> strs = getStrings(shortener, ids);
        finishDateTime = new Date();
        deltaTime = finishDateTime.getTime() - startDateTime.getTime();
        Helper.printMessage(Long.toString(deltaTime));
        if (strings.equals(strs))
            Helper.printMessage("Тест пройден.");
        else
            Helper.printMessage("Тест не пройден.");
    }
}
