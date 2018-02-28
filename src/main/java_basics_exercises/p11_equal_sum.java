import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p11_equal_sum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int leftSum = 0;
        int rightSum = 0;
        boolean isFound = false;

        for (int i = 0; i < input.length; i++) {
            leftSum = calcLeftSum(input, i);
            rightSum = calcRightSum(input, i);

            if (leftSum == rightSum){
                System.out.println(i);
                isFound = true;
            }
        }

        if (!isFound)
            System.out.println("no");

    }

    private static int calcLeftSum(int[] input, int i) {
        int result = 0;

        for (int j = i+1; j < input.length; j++) {
            result += input[j];
        }

        return  result;
    }

    private static int calcRightSum(int[] input, int i) {
        int result = 0;

        for (int j = 0; j < i; j++) {
            result += input[j];
        }

        return result;
    }
}
