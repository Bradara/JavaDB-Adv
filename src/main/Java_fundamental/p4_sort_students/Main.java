package p4_sort_students;

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

        Student(String firstNAme, String lastName) {
            this.firstname = firstNAme;
            this.lastName = lastName;
        }

        public String getFirstname() {
            return firstname;
        }

        public String getLastName() {
            return lastName;
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
            Student s = new Student(params[0], params[1]);
            students.add(s);
        }

        students.stream().sorted(Comparator.comparing(Student::getLastName).reversed().thenComparing(Student::getFirstname).reversed()).forEach(System.out::println);
    }
}
