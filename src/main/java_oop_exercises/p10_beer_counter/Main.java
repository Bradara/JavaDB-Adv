package p10_beer_counter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        try {
            while (!"end".equalsIgnoreCase(input = br.readLine())){
                int[] params = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
                BeerCounter.buyBeer(params[0]);
                BeerCounter.drinkBeer(params[1]);
            }
        } catch (Exception e){

        }

        System.out.printf("%d %d", BeerCounter.getBeerInStock(), BeerCounter.getBeerDrank());
    }
}
