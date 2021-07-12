#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> lottos, vector<int> win_nums) {
	vector<int> answer;
	int correct = 0, zero = 0;

	for (int lotto : lottos) {
		if (lotto == 0) {
			zero++;
			continue;
		}
		for (int win_num : win_nums) {
			if (lotto == win_num) {
				correct++;
				break;
			}
		}
	}

	// 최고 순위
	if (correct + zero == 0) answer.push_back(6);
	else answer.push_back(7 - (correct + zero));
	// 최저 순위
	if (correct == 0) answer.push_back(6);
	else answer.push_back(7 - correct);

	return answer;
}