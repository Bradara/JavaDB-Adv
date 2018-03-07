package p7_average_grade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0){
            String[] input = br.readLine().split("\\s+");
            Student s = new Student(input[0]);

            for (int i = 1; i < input.length; i++) {
                s.addGrade(Double.parseDouble(input[i]));
            }

            students.add(s);
        }

        students.stream().filter(s -> s.getAverageGrade() >= 5).sorted(Main::compareStudents)
                .forEach(s -> System.out.printf("%s -> %.2f%n", s.getName(), s.getAverageGrade()));

    }

    private static int compareStudents(Student a, Student b){
        if (a.getName().equals(b.getName())){
            return a.getAverageGrade() > b.getAverageGrade()? -1: 1;
        } else {
            return a.getName().compareTo(b.getName());
        }
    }
}
