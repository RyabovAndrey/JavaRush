package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User a = new User();
            a.setFirstName("Иван");
            a.setLastName("Иванов");
            a.setBirthDate(new GregorianCalendar(2000,5,25).getTime());
            a.setMale(true);
            a.setCountry(User.Country.UKRAINE);
            javaRush.users.add(a);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            SimpleDateFormat sft=new SimpleDateFormat("yyyy MM dd");
            PrintWriter printWriter=new PrintWriter(outputStream);
            printWriter.println(users.size());
            if (!users.isEmpty()) {
                for (int i = 0; i <users.size() ; i++)  {
                    printWriter.println(users.get(i).getFirstName());
                    printWriter.println(users.get(i).getLastName());
                    printWriter.println(new SimpleDateFormat("E yyyy MM dd hh mm ss a zzz").format(users.get(i).getBirthDate()));
                    printWriter.println(users.get(i).isMale()? "y":"n");
                    printWriter.println(users.get(i).getCountry().getDisplayedName());
                }
            }
            printWriter.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader r=new BufferedReader(new InputStreamReader(inputStream));
            int j=Integer.parseInt(r.readLine());
            if (j>0) {
                for (int i = 0; i <j; i++)  {
                    User u = new User();
                    u.setFirstName(r.readLine());
                    u.setLastName(r.readLine());
                    Date bdd = new SimpleDateFormat("E yyyy MM dd hh mm ss a zzz").parse(r.readLine());
                    u.setBirthDate(bdd);
                    u.setMale(r.readLine().equals("y"));
                    String co = r.readLine();
                    if (co.equals("Ukraine")) u.setCountry(User.Country.UKRAINE);
                    if (co.equals("Russia")) u.setCountry(User.Country.RUSSIA);
                    if (co.equals("Other")) u.setCountry(User.Country.OTHER);
                    users.add(u);
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
