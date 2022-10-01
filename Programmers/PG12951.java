public class PG12951 {

    public String solution(String s) {
        String[] split_s = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split_s.length; i++) {
            if (split_s[i].length() == 0) {
                sb.append(" ");
                continue;
            }

            char first_letter = Character.toUpperCase(split_s[i].charAt(0));
            String letters = split_s[i].substring(1, split_s[i].length()).toLowerCase();
            split_s[i] = first_letter + letters;

            sb.append(split_s[i]);
            if (i != split_s.length - 1) {
                sb.append(" ");
            }
        }

        int blank = s.length() - sb.length();
        while (blank-- > 0) {
            sb.append(" ");
        }

        String answer = sb.toString();
        return answer;
    }

}
