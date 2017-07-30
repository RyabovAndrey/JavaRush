package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
static {
    countries.put("UA","Ukraine");
    countries.put("RU","Russia");
    countries.put("CA","Canada");
}
    public static void main(String[] args) {
//        IncomeData simpleIncomeData = new tt();
//        IncomeDataAdapter adapter = new IncomeDataAdapter(simpleIncomeData);
//
//        System.out.println(adapter.getCompanyName());
//        System.out.println(adapter.getCountryName());
//        System.out.println(adapter.getName());
//        System.out.println(adapter.getPhoneNumber());
    }

    public static class IncomeDataAdapter implements Customer,Contact{
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return this.data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(this.data.getCountryCode());
        }

        @Override
        public String getName() {
            return this.data.getContactLastName()+", "+this.data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            String s=""+this.data.getPhoneNumber();
            int r=s.length();
            for (int i = 0; i <10-r ; i++) {
                s="0"+s;
            }
            String cc="+"+this.data.getCountryPhoneCode()+"("+s.substring(0,3)+")";
            String dd=s.substring(3,6)+"-"+s.substring(6,8)+"-"+s.substring(8,10);
            return cc+dd;
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
//    public static class tt implements IncomeData {
//
//        @Override
//        public String getCountryCode() {
//            return "UA";
//        }
//
//        @Override
//        public String getCompany() {
//            return "JavaRush Ltd.";
//        }
//
//        @Override
//        public String getContactFirstName() {
//            return "Ivan";
//        }
//
//        @Override
//        public String getContactLastName() {
//            return "Ivanov";
//        }
//
//        @Override
//        public int getCountryPhoneCode() {
//            return 38;
//        }
//
//        @Override
//        public int getPhoneNumber() {
//            return 51234567;
//        }
//    }
}