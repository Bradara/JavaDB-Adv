package p7_mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputStudent = br.readLine().split("\\s+");
        String[] inputWorker = br.readLine().split("\\s+");

        Student student = null;
        Worker worker = null;

        try {
            student = new Student(inputStudent[0], inputStudent[1], inputStudent[2]);
            worker = new Worker(inputWorker[0], inputWorker[1], inputWorker[2], inputWorker[3]);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }

        if (student != null)
            System.out.println(student);

        System.out.println();

        if (worker != null)
            System.out.println(worker);
    }
}
