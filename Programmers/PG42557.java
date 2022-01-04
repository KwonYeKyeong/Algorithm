import java.util.*;

public class PG42557 {

    // 방법 1) 정렬
    public boolean solution1(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                answer = false;
                break;
            }
        }

        return answer;
    }

    // 방법 2) 해시
    public boolean solution2(String[] phone_book) {
        Set<String> set = new HashSet<>();

        Arrays.stream(phone_book).forEach(phoneNumber -> set.add(phoneNumber));

        for (String phoneNumber : phone_book) {
            for (int i = 1; i < phoneNumber.length(); i++) {
                if (set.contains(phoneNumber.substring(0, i))) {
                    return false;
                }
            }
        }

        return true;
    }

}
