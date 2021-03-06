package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University  {
    String name;
    int age;
    private List<Student> students=new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for (Student s:students) {
            if (s.getAverageGrade()==averageGrade) return s;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        int  max = 0;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() > students.get(max).getAverageGrade())
                max = i;
        }
        return students.get(max);
    }

    public Student getStudentWithMinAverageGrade() {
        int  min = 0;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() < students.get(min).getAverageGrade())
                min = i;
        }
        return students.get(min);
    }
    public void expel(Student student) {
        students.remove(student);
    }
}