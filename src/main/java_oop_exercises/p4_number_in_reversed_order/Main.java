package p4_number_in_reversed_order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        float inputNumber = Float.parseFloat(br.readLine());
        DecimalNumber dm = new DecimalNumber(inputNumber);
        System.out.println(dm.printReversed());
    }
}
