package p2_students_by_first_last_name;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static class Student{

        private final String firstNAme;
        private final String lastName;

        Student(String firstNAme, String lastName) {
            this.firstNAme = firstNAme;
            this.lastName = lastName;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Student> students = new ArrayList<>();
        String input;

        while (!"end".equalsIgnoreCase(input=br.readLine())){
            String[] params = input.split("\\s+");
            Student s = new Student(params[0], params[1]);
            students.add(s);
        }

        students.stream().filter(s -> s.firstNAme.compareTo(s.lastName) < 0)
                .forEach(s -> System.out.println(s.firstNAme + " " + s.lastName));

    }
}
