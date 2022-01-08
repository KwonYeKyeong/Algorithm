import java.util.*;

public class PG43163 {

    public class Info {
        private boolean visited;
        private int depth;

        Info() {
            this.visited = false;
            this.depth = 0;
        }

        Info(boolean visited, int depth) {
            this.visited = visited;
            this.depth = depth;
        }

        public boolean isVisited() {
            return this.visited;
        }

        public int getDepth() {
            return this.depth;
        }

        public void visit() {
            this.visited = true;
        }

        public void increaseDepth(int depth) {
            this.depth = depth + 1;
        }

    }

    public int solution(String begin, String target, String[] words) {
        Queue<String> queue = new LinkedList<>();
        Map<String, Info> information = new HashMap<>();
        Arrays.stream(words).forEach(word -> information.put(word, new Info()));
        int answer = 0;

        queue.add(begin);
        information.put(begin, new Info(true, 0));
        while (!queue.isEmpty()) {
            String currentString = queue.poll();

            if (currentString.equals(target)) {
                answer = information.get(currentString).getDepth();
                break;
            }

            for (String word : words) {
                if (information.get(word).isVisited()) continue;

                boolean isDifferent = false;
                boolean check = false;
                for (int i = 0; i < word.length(); i++) {
                    if (currentString.charAt(i) != word.charAt(i) && isDifferent) {
                        check = false;
                        break;
                    }
                    if (currentString.charAt(i) != word.charAt(i) && !isDifferent) {
                        isDifferent = true;
                        check = true;
                    }
                }
                if (check) {
                    queue.add(word);
                    information.get(word).visit();
                    information.get(word).increaseDepth(information.get(currentString).getDepth());
                }
            }
        }

        return answer;
    }

}
