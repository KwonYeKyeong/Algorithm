public class PG60057 {

    public int solution(String s) {
        int answer = s.length();

        int unit = 1;
        while (unit <= s.length() / 2) {
            // 문자열 s를 단위 수(unit)으로 자르기
            int blocksLength = s.length() % unit == 0 ? s.length() / unit : s.length() / unit + 1;
            String[] blocks = new String[blocksLength];

            for (int i = 0; i < blocksLength; i++) {
                if (i == blocksLength - 1) {
                    blocks[i] = s.substring(unit * i, s.length());
                } else {
                    blocks[i] = s.substring(unit * i, unit * (i + 1));
                }
            }

            // 압축한 문자열 구하기
            String block = blocks[0];
            int count = 1;
            StringBuilder compression = new StringBuilder();

            for (int i = 1; i < blocksLength; i++) {
                if (block.equals(blocks[i])) {
                    count++;

                    if (i == blocksLength - 1) {
                        compression.append(count);
                        compression.append(block);
                    }
                } else {
                    if (count > 1) {
                        compression.append(count);
                    }
                    compression.append(block);
                    block = blocks[i];
                    count = 1;

                    if (i == blocksLength - 1) {
                        compression.append(block);
                    }
                }
            }

            // 가장 짧은 압축 문자열 계산
            if (compression.toString().length() < answer) {
                answer = compression.toString().length();
            }

            unit++;
        }

        return answer;
    }

}