package com.javarush.task.task12.task1215;

/* 
Кошки не должны быть абстрактными!
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static abstract class Pet {
        public abstract String getName();

        public abstract Pet getChild();
    }

    public static class Cat {
        public Cat getChild() {return new Cat();}
        public String getName() {return "d";}
    }

    public static class Dog {
        public Dog getChild() {return new Dog();}
        public String getName() {return "f";}
    }

}
