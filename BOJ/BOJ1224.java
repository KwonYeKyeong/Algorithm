import java.io.*;
import java.util.*;

public class BOJ1224 {

    public static int s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = Integer.parseInt(br.readLine());
        String[] tableString = br.readLine().split(" ");
        int[] tableInteger = Arrays.stream(tableString).mapToInt(t -> Integer.parseInt(t)).toArray();

        int students = Integer.parseInt(br.readLine());
        while (students-- > 0) {
            String[] info = br.readLine().split(" ");
            int num = Integer.parseInt(info[1]);
            switch (info[0]) {
                case "1" -> {
                    int i = 1;
                    while ((num * i - 1) < s) {
                        tableInteger[num * i - 1] = tableInteger[num * i - 1] ^ 1;
                        i++;
                    }
                }
                case "2" -> {
                    int start = num - 1;
                    int end = num - 1;
                    while (!outOfBound(start - 1, end + 1) &&
                            tableInteger[start - 1] == tableInteger[end + 1]) {
                        start--;
                        end++;
                    }
                    for (int i = start; i <= end; i++) {
                        tableInteger[i] = tableInteger[i] ^ 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s; i++) {
            sb.append(tableInteger[i]);
            sb.append(' ');

            if (i != 0 && i % 20 == 19) {
                sb.append('\n');
            }
        }
        System.out.println(sb.toString());
    }

    public static boolean outOfBound(int start, int end) {
        if (start >= 0 && end < s && start <= end) {
            return false;
        }
        return true;
    }

}