package p9_students;

public class Student {
    private static int count;
    private String name;

    public Student(String name) {
        this.name = name;
        count++;
    }

    public static int getCount() {
        return count;
    }
}
