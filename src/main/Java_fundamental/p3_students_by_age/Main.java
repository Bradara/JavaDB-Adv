package p3_students_by_age;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static class Student{

        private final String firstNAme;
        private final String lastName;
        private int age;

        Student(String firstNAme, String lastName, int age) {
            this.firstNAme = firstNAme;
            this.lastName = lastName;
            this.age = age;
        }

        @Override
        public String toString() {
            return this.firstNAme + " " + this.lastName + " " + this.age;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Student> students = new ArrayList<>();
        String input;

        while (!"end".equalsIgnoreCase(input=br.readLine())){
            String[] params = input.split("\\s+");
           Student s = new Student(params[0], params[1], Integer.parseInt(params[2]));
            students.add(s);
        }

        students.stream().filter(s -> s.age>=18 && s.age <= 24).forEach(System.out::println);
    }
}
