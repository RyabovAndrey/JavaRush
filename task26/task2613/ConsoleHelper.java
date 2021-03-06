package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader bis=new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message) {
        System.out.println(message);
    }
    public static String readString() {
        String string= null;
        try {
            string = bis.readLine();
        } catch (IOException ignored) {

        }
        return string;
    }
    public static String askCurrencyCode() throws InterruptOperationException {
        {
            String code = null;
            writeMessage("Please choice currency code:");
            while (true) {
                code = readString();
                if (code.length() == 3)
                    break;
                else
                    writeMessage("Error, Please choice again:");
            }
            return code.toUpperCase();
        }
    }
    public static String[] getValidTwoDigits(String currencyCode) {
        writeMessage("Input nominal and total:");
        String[] input;
        while (true) {
            input = readString().split(" ");
            int nominal = 0;
            int total = 0;
            try {
                nominal = Integer.parseInt(input[0]);
                total = Integer.parseInt(input[1]);
            } catch (Exception e) {
                writeMessage("Error, Repeat again:");
                continue;
            }
            if (nominal <= 0 || total <= 0) {
                writeMessage("Error, Repeat again:");
                continue;
            }
            break;
        }
        return input;
    }
}
