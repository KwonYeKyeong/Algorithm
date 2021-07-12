#include <string>
#include <vector>

using namespace std;

int solution(string s) {
	int answer = s.length();

	for (int i = 1; i < s.length(); i++) {
		string answer_s, tmp_s; // answer_s : 압축한 문자열, tmp_s : 반복되는지 비교하는 문자열
		int idx = 0, cnt = 0; // cnt : 반복되는 문자열의 수
		for (int j = 0; j < s.length() / i; j++) {
			if (tmp_s == "") {
				tmp_s = s.substr(idx, i);
				cnt++;
			}
			else if (tmp_s == s.substr(idx, i))
				cnt++;
			else if (tmp_s != s.substr(idx, i)) {
				if (cnt > 1)
					answer_s += to_string(cnt);
				answer_s += tmp_s;
				tmp_s = s.substr(idx, i);
				cnt = 1;
			}
			idx += i;
		}
		if (cnt > 1)
			answer_s += to_string(cnt);
		answer_s += tmp_s;
		if (idx < s.length())
			answer_s += s.substr(idx, s.length() - idx);

		if (answer_s.length() < answer)
			answer = answer_s.length();
	}

	return answer;
}