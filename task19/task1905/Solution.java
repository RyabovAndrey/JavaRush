package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();

    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }

    public static void main(String[] args) {
//        Customer customer=new tCustomer();
//        Contact contact=new tContact();
//        DataAdapter ad=new DataAdapter(customer,contact);
//        System.out.println(ad.getCountryCode());
//        System.out.println(ad.getCompany());
//        System.out.println(ad.getContactFirstName());
//        System.out.println(ad.getContactLastName());
//        System.out.println(ad.getDialString());

    }

    public static class DataAdapter implements RowItem{
        private Contact contact;
        private Customer customer;

        public DataAdapter(Customer customer, Contact contact) {
            this.contact=contact;
            this.customer=customer;
        }


        @Override
        public String getCountryCode() {
            String c=null;
            for (Map.Entry<String,String> d:countries.entrySet()) {
                if (d.getValue().equals(customer.getCountryName())) c=d.getKey();
            }
            return c;
        }

        @Override
        public String getCompany() {
            return this.customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String[] f=this.contact.getName().split(", ");
            return f[1];
        }

        @Override
        public String getContactLastName() {
            String[] f=this.contact.getName().split(", ");
            return f[0];
        }

        @Override
        public String getDialString() {
            String phone = "callto://" + contact.getPhoneNumber().replaceAll("[()-]","");

            return phone;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }

//    public static class tContact implements Contact {
//
//        @Override
//        public String getName() {
//            return "Ivanov, Ivan";
//        }
//
//        @Override
//        public String getPhoneNumber() {
//            return "+38(050)123-45-67";
//        }
//    }
//
//    public static class tCustomer implements Customer {
//
//        @Override
//        public String getCompanyName() {
//            return "JavaRush Ltd.";
//        }
//
//        @Override
//        public String getCountryName() {
//            return "Ukraine";
//        }
//    }
}