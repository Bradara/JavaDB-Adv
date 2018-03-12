package p8_weak_students;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static class Student{

        private final String firstname;
        private final String lastName;
        private List<Integer> marks;

        Student(String firstNAme, String lastName, List<Integer> marks) {
            this.firstname = firstNAme;
            this.lastName = lastName;
            this.marks = marks;
        }

        @Override
        public String toString() {
            return this.firstname + " " + this.lastName;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List< Student> students = new ArrayList<>();
        String input;

        while (!"end".equalsIgnoreCase(input=br.readLine())){
            String[] params = input.split("\\s+");
            List<Integer> marks = Arrays.stream(params).filter(Main::isNumber).mapToInt(Integer::parseInt).boxed()
                    .collect
                    (Collectors.toList());
             Student s = new Student(params[0], params[1], marks);
            students.add(s);
        }

        students.stream().filter(s -> s.marks.stream().filter(n-> n<=3).count()>1).forEach(System.out::println);
    }

    private static boolean isNumber(String s){

        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
