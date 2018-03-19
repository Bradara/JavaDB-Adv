package p9_animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        String[] params;

        while (true) {
            input = br.readLine();
            if ("Beast!".equalsIgnoreCase(input) || input == null) {
                break;
            }
            try {
                params = br.readLine().split("\\s+");
                Animal a = getAnimal(input, params);

                if (a == null)
                    throw new IllegalArgumentException("Invalid input!");

                System.out.println(input + " ");

                System.out.printf("%s %s %s%n", params[0], params[1], params[2]);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }


    }

    private static Animal getAnimal(String type, String[] params) {
        if (params.length != 3)
            throw new IllegalArgumentException("Invalid input!");

        Animal a;

        String name = params[0];
        String age = params[1];
        String gender = params[2];

        if ("Dog".equals(type))
            a = new Dog(name, age, gender);
        else if ("Cat".equals(type))
            a = new Cat(name, age, gender);
        else if ("Frog".equals(type))
            a = new Frog(name, age, gender);
        else if ("Kitten".equals(type))
            a = new Kitten(name, age);
        else if ("Tomcat".equals(type))
            a = new Tomcat(name, age);
        else
            return null;

        return a;
    }
}
