package com.javarush.task.task26.task2613;
import java.util.Locale;

public class CashMachine {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        CurrencyManipulator currencyManipulator=new CurrencyManipulator("RUB");
    }
}
