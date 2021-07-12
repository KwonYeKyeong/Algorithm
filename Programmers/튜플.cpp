#include <string>
#include <vector>
#include <algorithm> // sort()

using namespace std;

bool compare(pair<int, int> a, pair<int, int> b) {
	return a.second > b.second;
}
vector<int> solution(string s) {
	vector<int> answer;
	vector<pair<int, int>> vec(100001);
	int len = 0, tmp_len; // len : 가장 긴 중괄호 안 숫자 개수 = 원소의 개수(n)
	int val, tmp_val = 0, cnt;
	bool check; // 중괄호 안과 밖 ',' 구분

	for (int i = 1; i < s.length()-1; i++) {
		if (s[i] == '{') {
			tmp_len = 0;
			check = true;
		}
		else if (s[i] == ',' && check) { // 중괄호 안 ','
			val = tmp_val;
			tmp_val = 0;
			cnt = vec[val].second;
			vec[val].first = val;
			vec[val].second = cnt + 1;
			tmp_len++;
		}
		else if (s[i] == ',' && !check) // 중괄호 밖 ','
			continue;
		else if (s[i] == '}') {
			val = tmp_val;
			tmp_val = 0;
			cnt = vec[val].second;
			vec[val].first = val;
			vec[val].second = cnt + 1;
			tmp_len++;
			len = (len < tmp_len ? tmp_len : len);
			check = false;
		}
		else  // 숫자일 경우
			tmp_val = 10 * tmp_val + (s[i] - '0');
	}

	sort(vec.begin(), vec.end(), compare);

	for (int i = 0; i < len; i++)
		answer.push_back(vec[i].first);

	return answer;
}