#include <string>
#include <vector>
#include <algorithm> // sort()

using namespace std;

bool compare(pair<float, int> a, pair<float, int> b) {
	if (a.first == b.first)
		return a.second < b.second;
	return a.first > b.first;
}
vector<int> solution(int N, vector<int> stages) {
	vector<int> answer;
	vector<int> cnt(501);
	vector<pair<float, int>> ratio;
	float m = stages.size(); // 총 사용자 수

	for (int s : stages) 
		cnt[s]++;
	
	for (int i = 1; i <= N; i++) {
		if (m == 0) { // 스테이지에 도달한 유저가 없는 경우
			ratio.push_back(make_pair(0, i));
			continue;
		}
		float n = cnt[i]; // 클리어하지 못한 사용자 수
		ratio.push_back(make_pair(n / m, i));
		m -= n;
	}

	sort(ratio.begin(), ratio.end(), compare);

	for (int i = 0; i < N; i++)
		answer.push_back(ratio[i].second);

	return answer;
}