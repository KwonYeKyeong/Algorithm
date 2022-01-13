import java.io.*;
import java.util.*;

public class BOJ6443 {

    // 방법 1) 단어 그대로 배열에 저장 -> 메모리 초과
    // public static StringBuilder result = new StringBuilder();

    // public static void main(String[] args) throws IOException {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //     int n = Integer.parseInt(br.readLine());
    //     while (n-- > 0) {
    //         char[] word = br.readLine().toCharArray();
    //         boolean[] visited = new boolean[word.length];

    //         Arrays.sort(word);

    //         dfs(word, visited, new ArrayList<Character>(word.length));
    //     }

    //     System.out.println(result);
    //     br.close();
    // }

    // public static void dfs(char[] word, boolean[] visited, List<Character> characters) {
    //     if (characters.size() == word.length) {
    //         for(char c : characters){
    //             result.append(c);
    //         }
    //         result.append("\n");
    //         return;
    //     }

    //     for (int i = 0; i < word.length; i++) {
    //         if (!visited[i]) {
    //             visited[i] = true;
    //             characters.add(word[i]);
    //             dfs(word, visited, characters);
    //             visited[i] = false;
    //             characters.remove(characters.size() - 1);
    //         }
    //     }
    // }

    // 방법 2) 단어의 갯수 배열에 저장
    public static StringBuilder result = new StringBuilder();
    public static int[] alphabet;
    public static char[] save;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String word = br.readLine();

            alphabet = new int[26];
            save = new char[word.length()];

            for (int i = 0; i < word.length(); i++) {
                alphabet[word.charAt(i) - 'a']++;
            }

            dfs(0, word.length());
        }

        System.out.println(result);
        br.close();
    }

    public static void dfs(int cnt, int limit) {
        if (cnt == limit) {
            result.append(save).append("\n");
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (alphabet[i] > 0) {
                alphabet[i]--;
                save[cnt] = (char) (i + 'a');
                dfs(cnt + 1, limit);
                alphabet[i]++;
            }
        }
    }

}