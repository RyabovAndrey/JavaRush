package com.javarush.task.task14.task1410;

/* 
Дегустация вин
*/

public class Solution {
    public static void main(String[] args) {
        getDeliciousDrink().taste();
        System.out.println(getWine().getHolidayName());
        System.out.println(getBubblyWine().getHolidayName());
        System.out.println(getWine().getHolidayName());
    }

    public static Drink getDeliciousDrink() {
        Wine w=new Wine();
        return w;
    }

    public static Wine getWine() {
        Wine w=new Wine();
        return w;
    }

    public static Wine getBubblyWine() {
        Wine w=new BubblyWine();
        return w;
    }
}
