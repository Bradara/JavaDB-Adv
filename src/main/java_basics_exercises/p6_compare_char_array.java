import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p6_compare_char_array {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr1 = br.readLine().toCharArray();
        char[] arr2 = br.readLine().toCharArray();

        int len = arr1.length < arr2.length ? arr1.length : arr2.length;

        boolean isSorted = true;
        boolean isEqual = true;


        for (int i = 0; i < len; i++) {
            if (arr1[i] > arr2[i]) {
                isSorted = false;
                isEqual = false;
                break;
            } else if (arr1[i] < arr2[i]) {
                isEqual = false;
                break;
            }
        }

        if (isEqual) {
            boolean firstIsLonger = arr1.length < arr2.length ? false : true;

            if (firstIsLonger) {
                printCharArr(arr2);
                printCharArr(arr1);
            } else {
                printCharArr(arr1);
                printCharArr(arr2);
            }

            return;
        }


        if (isSorted) {
            printCharArr(arr1);
            printCharArr(arr2);
        } else {
            printCharArr(arr2);
            printCharArr(arr1);
        }

    }

    private static void printCharArr(char[] arr) {
        for (char c : arr) {
            if (c != 32)
            System.out.print(c);
        }

        System.out.println();
    }
}
