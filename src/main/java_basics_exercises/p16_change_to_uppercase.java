import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p16_change_to_uppercase {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String regex = "<upcase>(.*?)</upcase>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            String find = matcher.group();
            String m = matcher.group(1).toUpperCase();
           // System.out.println(m);
            input = input.replace(find, m);
        }

        System.out.println(input);
    }
}
