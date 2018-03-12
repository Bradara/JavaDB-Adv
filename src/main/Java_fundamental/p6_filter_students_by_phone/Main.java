package p6_filter_students_by_phone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static class Student {

        private final String firstname;
        private final String lastName;
        private String phone;

        Student(String firstNAme, String lastName, String phone) {
            this.firstname = firstNAme;
            this.lastName = lastName;
            this.phone = phone;
        }

        @Override
        public String toString() {
            return this.firstname + " " + this.lastName;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Student> students = new ArrayList<>();
        String input;

        while (!"end".equalsIgnoreCase(input = br.readLine())) {
            String[] params = input.split("\\s+");
            Student s = new Student(params[0], params[1], params[2]);
            students.add(s);
        }

        students.stream().filter(s -> s.phone.substring(0, 2).equalsIgnoreCase("02") || s.phone.substring(0,5).equalsIgnoreCase("+3592")).forEach(System.out::println);
    }
}
