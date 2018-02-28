import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p13_fit_str_in_20_shar {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int len = input.length();
        String result;

        if (len >= 20)
            result = input.substring(0,20);
        else
            result = addStars(input);

        System.out.println(result);
    }

    private static String addStars(String input) {
        StringBuilder sb = new StringBuilder(input);

        for (int i = input.length(); i < 20 ; i++) {
            sb.append("*");
        }

        return sb.toString();

    }
}
