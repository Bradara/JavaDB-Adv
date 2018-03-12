package p5_students_by_email_domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    static class Student {

        private final String firstname;
        private final String lastName;
        private String email;

        Student(String firstNAme, String lastName, String email) {
            this.firstname = firstNAme;
            this.lastName = lastName;
            this.email = email;
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

        students.stream().filter(s -> s.email.split("@")[1].equalsIgnoreCase("gmail.com")).forEach(System.out::println);
    }
}
