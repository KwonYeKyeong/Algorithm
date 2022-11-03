import java.io.*;
import java.util.*;

public class BOJ1302 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String book = br.readLine();
            map.put(book, map.getOrDefault(book, 0) + 1);
        }

        List<String> bestSeller = new ArrayList<>();
        int max = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
                bestSeller.clear();
                bestSeller.add(entry.getKey());
            } else if (max == entry.getValue()) {
                bestSeller.add(entry.getKey());
            }
        }

        bestSeller.sort(Comparator.naturalOrder());

        System.out.println(bestSeller.get(0));
    }

}
