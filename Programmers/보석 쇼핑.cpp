/*
문제 : 모든 보석의 종류를 포함하는 가장 짧은 구간 구하기
조건 : 가장 짧은 구간이 여러 개라면 시작 번호가 가장 작은 구간을 return
알고리즘 : 투 포인터
*/
#include <string>
#include <vector>
#include <map>

using namespace std;

vector<int> solution(vector<string> gems) {
	vector<int> answer(2);
	map<string, int> m; // key : 보석 종류, value : 보석의 빈도 수 
	int s = 0, e = 0;
	int type = 0, len = gems.size();

	for (string g : gems)
		m[g] = 0;

	answer[0] = s + 1;
	answer[1] = len;
	while (e <= gems.size()) {
		if (type < m.size()) {
			if (e == gems.size()) break;

			if (m[gems[e]] == 0)
				type++;
			m[gems[e]]++;
			e++;
		}
		else if (type == m.size()) {
			if (len > e - s) {
				len = e - s;
				answer[0] = s + 1;
				answer[1] = e;
			}

			if (m[gems[s]] == 1)
				type--;
			m[gems[s]]--;
			s++;
		}
	}

	return answer;
}