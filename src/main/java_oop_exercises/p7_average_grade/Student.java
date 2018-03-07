package p7_average_grade;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Double> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addGrade(double g){
        this.grades.add(g);
    }

    public double getAverageGrade(){
        return this.grades.stream().mapToDouble(a -> a).average().getAsDouble();
    }
}
