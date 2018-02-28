import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2_boolean_var {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean result = Boolean.parseBoolean(br.readLine());

        if (result)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
