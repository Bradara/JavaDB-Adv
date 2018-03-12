package p10_group_by_group;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        List<Person> people = new ArrayList<>();

        while (!"end".equalsIgnoreCase(input=br.readLine())){
            String[] params = input.split("\\s+");
            people.add(new Person(params[0] + " " +params[1], Integer.parseInt(params[2])));
        }

        people.stream().collect(Collectors.groupingBy(Person::getGroup)).forEach((key, value) -> System.out.printf("%d - %s%n", key, value.toString().replaceAll("\\[|\\]", "")));
    }
}
