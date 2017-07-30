package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {
    String s;
    int m;
    public Solution() {

    }

    protected Solution(String s) {
        this.s = s;
    }

    Solution(int m) {
        this.m = m;
    }

    private Solution(String s, int m) {
        this.s = s;
        this.m = m;
    }

    public static void main(String[] args) {

    }
}

