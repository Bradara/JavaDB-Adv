import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class p4_vowel_or_digit {
    private  static List<String> vowel = Arrays.asList("a", "o", "e", "u", "i");
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        if (vowel.contains(input))
            System.out.println("vowel");
        else if (tryParse(input))
            System.out.println("digit");
        else
            System.out.println("other");
    }

    private static boolean tryParse(String input) {
        try {
            int i = Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
