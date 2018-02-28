import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class p9_most_freq_number {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Map<Integer, Integer> freqByNum = new LinkedHashMap<>();

        for (int i : input) {
            if (freqByNum.containsKey(i))
                freqByNum.put(i, freqByNum.get(i)+1);
            else
                freqByNum.put(i, 1);
        }

       freqByNum.entrySet().stream().sorted((a,b) -> sort(a,b)).limit(1).forEach(a -> System.out.println(a
               .getKey()));
    }

    private static int sort(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
        if (a.getValue() > b.getValue())
            return -1;
        if (a.getValue() < b.getValue())
            return 1;
        if (a.getValue().equals(b.getValue()))
            return 1;

        return 0;
    }
}
