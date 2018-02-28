import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class p10_index_of_letters {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Character> alphabet = new ArrayList<>();

        for (char i = 'a'; i <= 'z' ; i++) {
            alphabet.add(i);
        }

        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            System.out.printf("%s -> %d%n", c, alphabet.indexOf(c));

        }
    }
}
