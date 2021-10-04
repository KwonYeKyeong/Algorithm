import java.util.*;

class PG77486 {
    int[] answer;

    class DaDanGae {
        String parent;
        int index;

        DaDanGae(String parent, int index){
            this.parent = parent;
            this.index = index;
        }
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, DaDanGae> tree = new HashMap<>();
        answer = new int[enroll.length];

        // 초기화
        for (int i = 0; i < enroll.length; i++) {
            tree.put(enroll[i], new DaDanGae(referral[i], i));
        }

        for (int i = 0; i < seller.length; i++) {
            int income = amount[i] * 100;
            calculateProfit(tree, seller[i], income);
        }

        return answer;
    }
    
    public void calculateProfit(Map<String, DaDanGae> tree, String seller, int income) {
        answer[tree.get(seller).index] += (income - income / 10);

        if (tree.get(seller).parent.equals("-")) {
            return;
        }
        if (income / 10 < 1) { // 시간초과 방지
            return;
        }
        calculateProfit(tree, tree.get(seller).parent, income / 10);
    }
}
