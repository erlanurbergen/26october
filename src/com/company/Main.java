package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Student> students = getStudent();
//        ArrayList<Student> arrayList = new ArrayList<>();
//
//        for (Student s: students){
//            if (s.getGroup().equals(Group.SIS2006)){
//                arrayList.add(s);
//            }
//        }
//
//        arrayList.forEach(System.out::println);
        // filter
//        List<Student> sis2006 = students.stream()
//                .filter(student -> student.getGroup().equals(Group.SIS2006) && student.getGpa() > 3.0)
//                .collect(Collectors.toList());
//
//        sis2006.forEach(System.out::println);
        // takeWhile

//        List<Student> collect = students.stream()
//                .takeWhile(student -> student.getGpa() < 3.5).collect(Collectors.toList());
//
//        collect.forEach(System.out::println);
        // dropWhile

//        students.stream()
//                .dropWhile(student -> student.getGpa() < 3.6)
//                .forEach(System.out::println);
        // anyMatch boolean
//        boolean b = students.stream()
//                .anyMatch(student -> student.getGpa() > 3.7);


//        System.out.println(b);
        // allMatch boolean

//        boolean b = students.stream()
//                .allMatch(student -> student.getGpa() > 2.9);
//
//        System.out.println(b);
        // distinct
//        List<Student> collect = students.stream()
//                .distinct().collect(Collectors.toList());
//
//        collect.forEach(System.out::println);
        // concat


//        Stream<Student> stream = Stream.of(new Student("Erlan", 3.1, Group.SIS2006), new Student("Dastan", 3.2, Group.SIS2006));
//        Stream<Student> stream2 = Stream.of(new Student("Bekzat", 3.1, Group.SIS2007), new Student("Kamaloddin", 3.2, Group.SIS2007));
//
//
//        List<Student> collect = Stream.concat(stream2, stream).collect(Collectors.toList());
//
//        collect.forEach(System.out::println);
        // sort
//        students.stream()
//                .sorted(Comparator.comparing(Student::getName))
//                .forEach(System.out::println);
        // max
//        students.stream()
//                .min(Comparator.comparing(Student::getGpa))
//                .ifPresent(System.out::println);
        // min
//        students.stream()
//                .min(Comparator.comparing(Student::getGpa))
//                .ifPresent(System.out::println);
        // group

        Map<Group, List<Student>> studentOfGroup = students.stream()
                .collect(Collectors.groupingBy(Student::getGroup));

        studentOfGroup.forEach((group, students1) -> {
            System.out.println(group);
            students1.forEach(System.out::println);

            System.out.println();
        });


    }

    private static List<Student> getStudent(){
        return List.of(
                new Student("Gulnur", 3.1, Group.SIS2006),
                new Student("Gulnur", 3.1, Group.SIS2006),
                new Student("Diana", 3.2, Group.SIS2007),
                new Student("Zhasmin", 3.2, Group.SIS2008),
                new Student("Zhasmin", 3.2, Group.SIS2008),
                new Student("Sayan", 3.5, Group.SIS2006),
                new Student("Ayadil", 3.6, Group.SIS2007),
                new Student("Ayadil", 3.6, Group.SIS2007),
                new Student("Aidos", 3.0, Group.SIS2008)
        );
    }
}
// api - application program interface
// jdk 8

enum Group{
    SIS2006, SIS2007, SIS2008;
}
class Student{
    private String name;
    private double gpa;
    private Group group;

    public Student(String name, double gpa, Group group) {
        this.name = name;
        this.gpa = gpa;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public Group getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(student.gpa, gpa) == 0 && Objects.equals(name, student.name) && group == student.group;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gpa, group);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gpa=" + gpa +
                ", group=" + group +
                '}';
    }
}