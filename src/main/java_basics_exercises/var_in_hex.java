import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class var_in_hex {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int output_in_dec = Integer.parseInt(br.readLine(), 16);

        System.out.println(output_in_dec);
    }
}
