package com.javarush.task.task20.task2025;

import java.util.*;

/*
Алгоритмы-числа
*/


public class Solution{
    private static long cntSearch;
    private static int N;
    private static int[] digitsMultiSet;
    private static List<Long> results;
    private static long maxPow;
    private static long minPow;
    private static long[][] pows;

    private static void genPows(int N) {
        //    if (N > 20) throw new IllegalArgumentException();
        pows = new long[10][N + 1];
        for (int i = 0; i < pows.length; i++) {
            long p = 1;
            for (int j = 0; j < pows[i].length; j++) {
                pows[i][j] = p;
                p *= i;
            }
        }
    }

    private static boolean check(long pow) {
        cntSearch++;
        if (pow >= maxPow) return false;
        if (pow < minPow) return false;
        int[] testMultiSet = new int[10];
        while (pow > 0) {
            int i = (int) (pow % 10);
            testMultiSet[i]++;
            pow = pow / 10;
        }
        for (int i = 0; i < 10; i++) {
            if (testMultiSet[i] != digitsMultiSet[i]) return false;
        }
        return true;
    }

    private static void search(int digit, int unused, long pow) {
        if (digit == 10) {
            if (check(pow)) results.add(pow);
            return;
        }
        if (digit == 9) {
            digitsMultiSet[digit] = unused;
            search(digit + 1, 0, pow + unused * pows[digit][N]);
        } else {
            for (int i = 0; i <= unused; i++) {
                digitsMultiSet[digit] = i;
                search(digit + 1, unused - i, pow + i * pows[digit][N]);
            }
        }
    }

    public static List<Long> generate(int maxN) {
        if (maxN >= 20) throw new IllegalArgumentException();
        genPows(maxN);
        results = new ArrayList<>();
        digitsMultiSet = new int[10];
        cntSearch = 0;
        for (N = 1; N <= maxN; N++) {
            minPow = (long) Math.pow(10, N - 1);
            maxPow = (long) Math.pow(10, N);
            search(0, N, 0);
        }
        Collections.sort(results);
        return results;
    }

    public static long[] getNumbers(long N) {

        List list = generate((int) (Math.log10(N) + 1));
        long[] a = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = (long)list.get(i);
        }

        return a;

    }
    public static void main(String[] args) {
        Long t0 = System.currentTimeMillis();
        long[] numbers = getNumbers(Long.MAX_VALUE);
        Long t1 = System.currentTimeMillis();
        System.out.println("time: " + (t1 - t0) / 1000d + " sec");
        System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " mb");
        System.out.println(Arrays.toString(numbers));
    }
}
