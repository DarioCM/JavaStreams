package com.example.javastreams.component;


import java.util.*;
import java.util.stream.Collectors;

public class Process {

    public static void main(String[] args) {

        System.out.println(">>>>>>>>");
        // create list of Student
        List<Student> list = createList();

        // Find list of students whose first name starts with alphabet A
        List<Student> lstStuName = list.stream().filter(dt -> dt.getFirstName().startsWith("A"))
                .collect(Collectors.toList());
        System.out.println("List of students whose name starts with letter A : "+lstStuName);

        // Group The Student By Department Names
        Map<String, List<Student>> mapData = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName));
        System.out.println("Students grouped by the department names : "+mapData);

        // Find the total count of student using stream
        long countStudent = list.stream().count();
        System.out.println("Total count of students : "+countStudent);

        // Find the max age of student
        OptionalInt maxAge = list.stream().mapToInt(dt -> dt.getAge()).max();
        System.out.println("Max age of student : "+maxAge.getAsInt());

        // Find all departments names
        List<String> lstDepartments = list.stream().map(dt -> dt.getDepartmantName()).distinct()
                .collect(Collectors.toList());
        System.out.println("All distinct department names : "+lstDepartments);

        // Find the count of student in each department
        Map<String, Long> countStudentInEachdept = list.stream()
                .collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()));
        System.out.println("Student count in each department : "+countStudentInEachdept);

        // Find the list of students whose age is less than 30
        List<Student> lstStudent = list.stream().filter(dt -> dt.getAge() < 30).collect(Collectors.toList());
        System.out.println("List of students whose age is less than 30 : "+lstStudent);

        //  Find the list of students whose rank is in between 50 and 100
        List<Student> lstStu = list.stream().filter(dt -> dt.getRank() > 50 && dt.getRank() < 100)
                .collect(Collectors.toList());
        System.out.println("List of students whose rank is between 50 and 100 : "+lstStu);

        // Find the average age of male and female students
        Map<String, Double> mapAvgAge = list.stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
        System.out.println("Average age of male and female students : "+mapAvgAge);

        // Find the department who is having maximum number of students
        Map.Entry<String, Long> entry = list.stream()
                .collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting())).entrySet().stream()
                .max(Map.Entry.comparingByValue()).get();
        System.out.println("Department having maximum number of students : "+entry);

        // Find the Students who stays in Delhi and sort them by their names
        List<Student> lstDelhistudent = list.stream().filter(dt -> dt.getCity().equals("Delhi"))
                .sorted(Comparator.comparing(Student::getFirstName)).collect(Collectors.toList());
        System.out.println("List of students who stays in Delhi and sort them by their names : "+lstDelhistudent);

        // Find the average rank in all departments
        Map<String, Double> collect = list.stream()
                .collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.averagingInt(Student::getRank)));
        System.out.println("Average rank in all departments  : "+collect);

        // Find the highest rank in each department
        Map<String, Optional<Student>> studentData = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName,
                Collectors.maxBy(Comparator.comparing(Student::getRank))));
        System.out.println("Highest rank in each department  : "+studentData);

        // Find the list of students and sort them by their rank
        List<Student> stuRankSorted = list.stream().sorted(Comparator.comparing(Student::getRank).reversed())
                .collect(Collectors.toList());
        System.out.println("List of students sorted by their rank  : "+stuRankSorted);

        // Find the student who has second rank
        Student student = list.stream().sorted(Comparator.comparing(Student::getRank).reversed()).skip(1).findFirst().get();
        System.out.println("Second highest rank student  : "+student);
    }

    static List<Student> createList(){
        List<Student> list = Arrays.asList(
                new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
                new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
                new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
                new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
                new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
                new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
                new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
                new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
                new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
                new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));
        return list;
    }
}
