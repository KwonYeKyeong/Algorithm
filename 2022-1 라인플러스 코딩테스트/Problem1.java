public class Problem1 {

    public int solution(String[] logs) {
        final String[] form = {
                "team_name", ":", "",
                "application_name", ":", "",
                "error_level", ":", "",
                "message", ":", ""
        };

        int answer = 0;
        for (String log : logs) {
            if (log.length() > 100) { // 로그의 길이는 100 이하여야 합니다.
                answer++;
                continue;
            }

            String trimLog = log.trim();
            if (!log.equals(trimLog)) { // 문자열 앞뒤에 공백이 있으면 안됩니다.
                answer++;
                continue;
            }

            String replaceLog = log.replaceAll("\\s+", " ");
            if (!log.equals(replaceLog)) { // 연속된 공백이 있으면 안됩니다.
                answer++;
                continue;
            }

            String[] splitLog = log.split(" ");
            if (splitLog.length != form.length) { // 일부분이 누락되거나 내용에 공백이 들어가면 안됩니다.
                answer++;
                continue;
            }
            for (int i = 0; i < form.length; i++) {
                if (i == 2 || i == 5 || i == 8 || i == 11) {
                    if (!isAlpha(splitLog[i])) { // 내용에 알파벳 외 다른 문자가 들어가면 안됩니다.
                        answer++;
                        break;
                    }
                } else if (!splitLog[i].equals(form[i])) { // 기존 형식과 일치하지 않습니다.
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }

    private boolean isAlpha(String log) {
        return log.matches("[a-zA-Z]+");
    }

}