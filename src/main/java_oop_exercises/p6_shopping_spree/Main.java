package p6_shopping_spree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    private static Map<String, Person> personList = new LinkedHashMap<>();
    private static Map<String, Product> productList = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputPerson = br.readLine().split(";");
        String[] inputProduct = br.readLine().split(";");

        try {
            addPersonToList(inputPerson);
            addProductToList(inputProduct);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        String input;

        try {
            while (!(input = br.readLine()).equalsIgnoreCase("end")) {
                String[] params = input.split(" ");
                String productName = params[1];
                String personName = params[0];

                if (productList.containsKey(productName) && personList.containsKey(personName)) {
                    Product product = productList.get(productName);
                    personList.get(personName).buyProduct(product);
                }
            }
        } catch (Exception e) {

        } finally {

        }

        for (Person person : personList.values()) {
            System.out.print(person);
        }
    }

    private static void addProductToList(String[] inputProduct) {
        for (String s : inputProduct) {
            String[] params = s.split("=");
            Product product = new Product(params[0], Integer.parseInt(params[1]));
            productList.put(params[0], product);
        }
    }

    private static void addPersonToList(String[] inputPerson) {
        for (String p : inputPerson) {
            String[] params = p.split("=");
            Person person = new Person(params[0], Integer.parseInt(params[1]));
            personList.put(params[0], person);
        }
    }
}
