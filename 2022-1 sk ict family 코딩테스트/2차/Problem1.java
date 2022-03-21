import java.util.*;

public class Problem1 {

    public String[] solution(String[] goods) {
        List<String> answer = new LinkedList<>();

        for (String good : goods) {
            int wordLength = good.length() + 1;
            Set<String> wordSet = new TreeSet<>();
            for (int len = 1; len <= good.length(); len++) {
                for (int start = 0; start <= (good.length() - len); start++) {
                    String searchWord = good.substring(start, start + len);
                    if (isUnique(goods, good, searchWord)) {
                        if (wordLength > searchWord.length()) {
                            wordLength = searchWord.length();
                            wordSet.clear();
                        }
                        wordSet.add(searchWord);
                    }
                }

                if (wordLength < good.length()) {
                    break;
                }
            }

            if (wordSet.isEmpty()) {
                wordSet.add("None");
            }
            answer.add(String.join(" ", wordSet));
        }

        return answer.toArray(String[]::new);
    }

    public boolean isUnique(String[] goods, String g, String word) {
        for (String good : goods) {
            if (good.equals(g)) {
                continue;
            }
            if (good.contains(word)) {
                return false;
            }
        }
        return true;
    }

}
