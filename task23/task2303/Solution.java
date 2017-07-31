package com.javarush.task.task23.task2303;

import jdk.nashorn.internal.ir.annotations.Immutable;

/*
Запрети создание экземпляров класса
*/
public class Solution {

    public abstract static class Listener implements Immutable{
        public void onMouseDown(int x, int y) {
            //do something on mouse down event
        }

        public void onMouseUp(int x, int y) {
            //do something on mouse up event
        }
    }

    public static void main(String[] args) {

    }
}
