package p9_students_enrolled_in_2014_2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static class Student{

        private final String facultyNumber;

        private List<Integer> marks;

        Student(String facultyNumber, List<Integer> marks) {
            this.facultyNumber = facultyNumber;
            this.marks = marks;
        }

        @Override
        public String toString() {
            return this.marks.toString().replaceAll("\\[|\\]|,", "");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Student> students = new ArrayList<>();
        String input;

        while (!"end".equalsIgnoreCase(input=br.readLine())){
            String[] params = input.split("\\s+");
            List<Integer> marks = Arrays.stream(params).filter(Main::isNumber).mapToInt(Integer::parseInt).boxed().collect
                    (Collectors.toList());
            Student s = new Student(params[0], marks);
            students.add(s);
        }

        students.stream().filter(s -> s.facultyNumber.substring(4, 6).matches("14|15")).forEach(System.out::println);

    }


    private static boolean isNumber(String s) {
        if (s.length() <= 1) {
            try {
                Integer.parseInt(s);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        } else
            return false;
    }
}
