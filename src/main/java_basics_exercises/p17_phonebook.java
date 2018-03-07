import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p17_phonebook {

    private static Map<String, String> phonebook = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while (!(input=br.readLine()).equalsIgnoreCase("END")){
            String[] command = input.split(" ");

            if (command[0].equalsIgnoreCase("a"))
                phonebook.put(command[1], command[2]);

            if (command[0].equalsIgnoreCase("s")){
                if (phonebook.containsKey(command[1]))
                    System.out.printf("%s -> %s%n", command[1], phonebook.get(command[1]));
                else
                    System.out.printf("Contact %s does not exist.%n", command[1]);
            }

            if (command[0].equalsIgnoreCase("ListAll"))
                printMap();
        }
    }

    private static void printMap() {
        for (Map.Entry<String, String> kv : phonebook.entrySet()) {
            System.out.printf("%s -> %s%n", kv.getKey(), kv.getValue());
        }
    }
}
