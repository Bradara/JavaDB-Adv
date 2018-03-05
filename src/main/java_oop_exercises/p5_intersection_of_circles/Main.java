package p5_intersection_of_circles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] paramsForA = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] paramsForB = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Circle a = new Circle(paramsForA[0], paramsForA[1], paramsForA[2]);
        Circle b = new Circle(paramsForB[0], paramsForB[1], paramsForB[2]);

        System.out.println(Circle.isIntersect(a,b));
    }
}
