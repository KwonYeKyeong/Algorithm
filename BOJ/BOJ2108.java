import java.io.*;
import java.util.*;

public class BOJ2108 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Integer> map = new HashMap<>();
        double mean = 0;
        int median = 0, mode = 0, range;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            map.put(input, map.getOrDefault(input, 0) + 1);
            mean += input;
        }

        mean /= n;

        int[] keys = map.keySet().stream().mapToInt(i -> i).toArray();
        Arrays.sort(keys);

        int medianIndex = n / 2 + 1, modeValue = 0;
        boolean second = false;
        for (int key : keys) {
            int value = map.get(key);

            if (modeValue < value) {
                modeValue = value;
                mode = key;
                second = false;
            } else if (modeValue == value && !second) {
                mode = key;
                second = true;
            }

            if (medianIndex > 0) {
                medianIndex -= value;
                if (medianIndex <= 0) {
                    median = key;
                }
            }
        }

        range = keys[keys.length - 1] - keys[0];

        System.out.println(Math.round(mean));
        System.out.println(median);
        System.out.println(mode);
        System.out.println(range);
    }

}