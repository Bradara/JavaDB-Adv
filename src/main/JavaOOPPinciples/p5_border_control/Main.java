package p5_border_control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        List<Birthable> citizens = new ArrayList<>();

        while (!"end".equalsIgnoreCase(input = br.readLine())){
            String[] params = input.split("\\s+");

            if (params[0].equalsIgnoreCase("Citizen"))
                citizens.add(new Person(params[1], params[2], params[3], params[4]));

            if (params[0].equalsIgnoreCase("Robot"))
                citizens.add(new Robot(params[1], params[2]));

            if (params[0].equalsIgnoreCase("Pet"))
                citizens.add(new Pet(params[1], params[2]));
        }

        String fakeIdEnd = br.readLine();

        for (Birthable birthable : citizens) {
            if (birthable.getBirthday().endsWith(fakeIdEnd))
                System.out.println(birthable.getBirthday());
        }
    }
}
