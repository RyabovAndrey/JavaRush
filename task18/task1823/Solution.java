package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String m;
        while(!"exit".equals(m=reader.readLine())) {
            ReadThread r=new ReadThread(m);
            r.start();
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) throws IOException {
            this.fileName=fileName;
        }

        @Override
        public void run() {
            try {
                FileInputStream f = new FileInputStream(fileName);
                Map<Integer, Integer> n = new HashMap<>();
                while (f.available() > 0) {
                    int d = f.read();
                    if (n.containsKey(d)) n.replace(d, n.get(d) + 1);
                    else n.put(d, 1);
                }
                f.close();
                int ma = Integer.MIN_VALUE;
                int ch = 0;
                for (Map.Entry l : n.entrySet()) {
                    if (ma < Integer.parseInt( l.getValue().toString())) {
                        ch = Integer.parseInt( l.getKey().toString());
                    }
                    ma = Math.max(ma, (int) l.getValue());
                }

                synchronized (resultMap) {
                    resultMap.put(fileName, ch);
                }

            }catch (IOException e){}
        }
    }
}
