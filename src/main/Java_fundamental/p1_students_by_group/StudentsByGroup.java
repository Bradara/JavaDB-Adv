package p1_students_by_group;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentsByGroup {
    static class Student{
        private String firstName;
        private String lastName;
        private int group;

        Student(String firstName, String lastName, int group) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.group = group;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        List<Student> students = new ArrayList<>();

        while (!"end".equalsIgnoreCase(input = br.readLine())){
            String[] param = input.split("\\s+");
            Student s = new Student(param[0], param[1], Integer.parseInt(param[2]));
            students.add(s);
        }



        students.stream().filter(s -> {
            return s.group == 2;
        }).sorted(Comparator.comparing(s -> s.firstName)).forEach(s-> System
                .out.println(s.firstName + " " + s.lastName));
    }
}
