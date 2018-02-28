import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p8_max_seq_increase_elem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int index = 0;
        int len = 0;
        int tempLen = 0;


        for (int i = 1; i < input.length; i++) {
            if (input[i] > input[i-1])
                tempLen++;
            else
                tempLen = 0;

            if (tempLen > len) {
                len = tempLen;
                index = i-len;
            }
        }

        if (len > 0) {

            for (int i = index; i <= index + len; i++) {
                System.out.print(input[i]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
