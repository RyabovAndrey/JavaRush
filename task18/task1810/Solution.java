package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String s=reader.readLine();
            FileInputStream f=new FileInputStream(s);
            if (f.available()>=1000) {
                f.close();
            }
            else {
                f.close();
                break;
            }

        }
        throw new DownloadException();
    }

    public static class DownloadException extends Exception {

    }
}
