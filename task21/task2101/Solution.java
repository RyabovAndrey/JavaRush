package com.javarush.task.task21.task2101;

import java.io.ByteArrayInputStream;

/*
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);

        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] rez = new byte[4];
        int z;
        int coefa;
        int coefb;
        for (int i = 0; i <4 ; i++) {
            int a=ip[i];
            int b=mask[i];
            coefa=(a<0?1:0);
            coefb=(b<0?1:0);
            z=(coefa*256 + a) & (coefb*256+b);
            rez[i]=(byte) (z);
        }
        return rez;
    }

    public static void print(byte[] bytes) {
        ByteArrayInputStream fis=new ByteArrayInputStream(bytes);
        String maket = "00000000";
        String temp;
        int a;
        while (fis.available()>0) {
            a=fis.read();
            temp=Integer.toBinaryString(a);
            if (temp.length()<8)
                temp=maket.substring(0,8-temp.length())+temp;
            System.out.print(temp + " ");
        }
        System.out.println();
    }
}
