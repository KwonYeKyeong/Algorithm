import java.util.*;

public class PG72412 {

    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (String i : info) {
            String[] data = i.split(" ");
            String[] language = { data[0], "-" };
            String[] position = { data[1], "-" };
            String[] career = { data[2], "-" };
            String[] favorite = { data[3], "-" };
            int score = Integer.parseInt(data[4]);

            // 1. 모든 경우의 수 저장
            for (String l : language) {
                for (String p : position) {
                    for (String c : career) {
                        for (String f : favorite) {
                            String[] keyData = { l, p, c, f };
                            String key = String.join(" ", keyData);

                            if (!map.containsKey(key)) {
                                map.put(key, new ArrayList<>());
                            }
                            List<Integer> scoreList = map.get(key);
                            scoreList.add(score);
                        }
                    }
                }
            }
        }

        // 2. 정렬
        for (List<Integer> values : map.values()) {
            values.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer a, Integer b) {
                    return a - b;
                }
            });
        }

        int[] answer = new int[query.length];
        int idx = 0, cnt = 0;
        for (String q : query) {
            cnt = 0;
            String[] conditions = q.split(" and ");
            int score = Integer.parseInt(conditions[3].split(" ")[1]);
            conditions[3] = conditions[3].split(" ")[0];
            String key = String.join(" ", conditions);

            if (map.containsKey(key)) {
                List<Integer> scoreList = map.get(key);
                // 여기서 정렬하면 시간초과

                // 3. 이분 탐색
                int targetIdx = binarySearch(scoreList, score);
                cnt = scoreList.size() - targetIdx;
            }

            answer[idx++] = cnt;
        }

        return answer;
    }

    private int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1, mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

}

/*
// 처음 풀이방법 => 시간초과
// 이유 : query 최대 100,000, keyArray 최대 50,000 -> 최악 5,000,000,000
import java.util.*;

class Solution {
    
    public class Applicant {
        String language;
        String position;
        String career;
        String favorite;

        Applicant(String language, String position, String career, String favorite) {
            this.language = language;
            this.position = position;
            this.career = career;
            this.favorite = favorite;
        }
    }

    public int[] solution(String[] info, String[] query) {
        Map<Integer, List<Applicant>> map = new HashMap<>();
        for (String i : info) {
            String[] data = i.split(" ");
            if (!map.containsKey(Integer.parseInt(data[4]))) {
                map.put(Integer.parseInt(data[4]), new ArrayList<Applicant>());
            }
            List<Applicant> list = map.get(Integer.parseInt(data[4]));
            list.add(new Applicant(data[0], data[1], data[2], data[3]));
        }

        int[] keyArray = new int[map.size()];
        int idx = 0;
        for (int key : map.keySet()) {
            keyArray[idx++] = key;
        }
        Arrays.sort(keyArray);

        int[] answer = new int[query.length];
        int cnt = 0;
        idx = 0;
        for (String q : query) {
            cnt = 0;
            String[] temp = q.split(" ");
            int score = Integer.parseInt(temp[7]);

            int ret = binarySearch(keyArray, score);

            for (int i = ret; i < keyArray.length; i++) {
                int key = keyArray[i];
                List<Applicant> list = map.get(key);
                for (Applicant a : list) {
                    if (temp[0].equals("-") || a.language.equals(temp[0])) {
                        if (temp[2].equals("-") || a.position.equals(temp[2])) {
                            if (temp[4].equals("-") || a.career.equals(temp[4])) {
                                if (temp[6].equals("-") || a.favorite.equals(temp[6])) {
                                    cnt++;
                                }
                            }
                        }
                    }
                }
            }

            answer[idx++] = cnt;
        }

        return answer;
    }

    private int binarySearch(int[] array, int target) {
        int low = 0, high = array.length - 1, mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    
}
*/