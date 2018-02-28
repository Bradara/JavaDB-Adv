import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p5_int_to_hex_and_binary {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        System.out.println((Integer.toString(input, 16)).toUpperCase());
        System.out.println(Integer.toString(input, 2));
    }
}
