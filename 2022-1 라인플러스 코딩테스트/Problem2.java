public class Problem2 {

    public boolean[] alphabet;
    public int[] score;
    public int maxScore;

    public int solution(String[] sentences, int n) {
        alphabet = new boolean[27];
        score = new int[sentences.length];

        for (int i = 0; i < sentences.length; i++) {
            score[i] = sentences[i].length() + countCapitalLetter(sentences[i]);
            if (countCapitalLetter(sentences[i]) > 0) {
                alphabet[26] = true; // shift
            }

            String lowerSentence = sentences[i].toLowerCase();
            for (int j = 0; j < lowerSentence.length(); j++) {
                if (lowerSentence.charAt(j) == ' ') {
                    continue;
                }
                alphabet[lowerSentence.charAt(j) - 'a'] = true;
            }
        }

        maxScore = 0;
        combination(sentences, new boolean[27], new boolean[27], 0, 0, n);

        return maxScore;
    }

    private void combination(String[] sentences, boolean[] collectedLetters, boolean[] visited,
            int idx, int cur, int n) {
        if (cur == n) {
            int curScore = 0;
            for (int i = 0; i < score.length; i++) {
                boolean check = true;
                for (int j = 0; j < sentences[i].length(); j++) {
                    if (sentences[i].charAt(j) == ' ') {
                        continue;
                    }
                    if (sentences[i].charAt(j) - 'A' > 25 && !collectedLetters[sentences[i].charAt(j) - 'a']) {
                        check = false;
                        break;
                    }
                    if (sentences[i].charAt(j) - 'A' < 26 &&
                            (!collectedLetters[sentences[i].charAt(j) - 'A'] || !collectedLetters[26])) {
                        check = false;
                        break;
                    }
                }

                if (check) {
                    curScore += score[i];
                }
            }

            maxScore = Math.max(maxScore, curScore);

            return;
        }

        for (int i = idx; i < 27; i++) {
            if (alphabet[i] && !visited[i]) {
                visited[i] = true;
                collectedLetters[i] = true;
                combination(sentences, collectedLetters, visited, i + 1, cur + 1, n);
                visited[i] = false;
                collectedLetters[i] = false;
            }
        }
    }

    private int countCapitalLetter(String sentence) {
        int count = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                continue;
            }
            if (sentence.charAt(i) - 'a' < 0) {
                count++;
            }
        }
        return count;
    }

}
