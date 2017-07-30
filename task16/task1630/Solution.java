package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;


    static {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName=reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            secondFileName=reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface{
        String fn="",con="";
        @Override
        public void setFileName(String fullFileName) {
            fn=fullFileName;
        }

        @Override
        public String getFileContent() {
            return con;
        }

        @Override
        public void run() {
            String l="";
            try {
                BufferedReader fl=new BufferedReader(new FileReader(fn));
                while (l!=null) {
                    try {
                        l=fl.readLine();
                        if (l!=null) {
                            if (con.equals(""))
                            con=con+l;
                            else con=con+" "+l;
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
